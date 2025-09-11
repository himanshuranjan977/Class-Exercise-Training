package com.gl.security;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	RoleRepo roleRepo;
	
	@Autowired
	BCryptPasswordEncoder encoder;
	
	
	@PostMapping("/create-role")
	public String createRole( String name) {
	    
	    if (roleRepo.findByName(name).isEmpty()) {
	        Role role =new Role(name);
	        roleRepo.save(role);
	        return "Role created";
	    }else {
	    	return "Role name already taken";
	    }
	    
	}
	// create users
	@PostMapping("/create-user")
	public String createUser(String username, String password, String roleName) {

	    // Check if role exists
	    if (roleRepo.findByName(roleName).isEmpty()) {
	        return "Invalid role";
	    }

	    Role role = roleRepo.findByName(roleName).get();

	    // Check if username already exists
	    if (userRepo.findByUsername(username).isEmpty()) {
	    	User user = new User(username, password);
	    	user.setPassword(encoder.encode(password));
		    Set<Role> myRoles =new HashSet<>();
		    myRoles.add(role);
		    user.setRoles(myRoles);
		    userRepo.save(user);

		    return "User created";
	    	
	    }
	    else {
	    	return "Username is already taken";
	    }

	}

}
