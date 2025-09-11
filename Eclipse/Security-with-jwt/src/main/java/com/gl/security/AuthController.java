package com.gl.security;


import java.util.Map;
import java.util.Set;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AuthController {
	
	@Autowired
	UserRepository userRepository;
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	JWTService jwtService;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping("/open/sign-up-admin")
	public String signupAdmin(@RequestParam String username, @RequestParam String password) {
	if(userRepository.existsByUsername(username)) {
		
	     throw new RuntimeException("Username already used");
	}
	
	Role adminRole = roleRepository.findByName("ROLE_ADMIN").get();
	

	

	User user = new User(username, password);
	user.setPassword(passwordEncoder.encode(password));
	user.setRoles( Set.of(adminRole));
	userRepository.save(user);
	//create the token for this user
	String token = jwtService.generateToken(user.getUsername(), Map.of("roles", "ROLE_ADMIN") );
	return token;
	}
	
	@PostMapping("/open/sign-up-user")
	public String signupUser(@RequestParam String username, @RequestParam String password) {
	if(userRepository.existsByUsername(username)) {
	throw new RuntimeException("Username already used");
	}
	Role adminRole = roleRepository.findByName("ROLE_USER").get();
	User user = new User(username, password);
	user.setPassword(passwordEncoder.encode(password));
	user.setRoles( Set.of(adminRole));
	userRepository.save(user);
	//crate the token for this user
	String token = jwtService.generateToken(username, Map.of("roles", "ROLE_USER") );
	return token;
	}
	
	// login
	@PostMapping("/open/login")
	public String adminLogin( String username, String password) {

	    // authenticate user name and password
	    authenticationManager.authenticate(
	            new UsernamePasswordAuthenticationToken(username, password));

	  //generate j w t
	    String token = jwtService.generateToken(username, Map.of());
	    return token;
	}
	
	@GetMapping("/admin/test")
	public String adminTest() {
	    return "Welcome to admin api";
	}
	//eyJhbGciOiJIUzI1NiJ9.eyJyb2xlcyI6IlJPTEVfQURNSU4iLCJzdWIiOiJSYW1hbiIsImlhdCI6MTc1NzA2NjczOCwiZXhwIjoxNzU3MDcwMzM4fQ.f1LKeUW5f33BR8UCd8YWWxdLgyIPdYoZU2iaSesul7U

}
