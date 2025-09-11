package com.gl.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	@Autowired
	CustomerUserDetailService customerUserDetailService;
	
	//encrypt the password
	//encrypt the password
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
	}
	
	
	
	//authentication
	public DaoAuthenticationProvider authenticationProvider() {
	DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	authProvider.setUserDetailsService(customerUserDetailService); //loading the user from service file
	authProvider.setPasswordEncoder(passwordEncoder()); //setting the encrypt algorithm
	return authProvider;
	}
	//authentication
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable() ).authorizeHttpRequests(auth -> auth
				.requestMatchers("/create-user").permitAll()
				.requestMatchers("/create-role").permitAll()
				.requestMatchers("/admin/**").hasRole("admin")
				.requestMatchers("/student/**").hasRole("student")
				.anyRequest().authenticated()
				).httpBasic(); // spelling was wrong: httpBasi() → httpBasic()

	    return http.build();
	}
	
	


	

}
