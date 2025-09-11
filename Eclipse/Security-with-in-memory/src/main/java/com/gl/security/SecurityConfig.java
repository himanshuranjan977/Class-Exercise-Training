package com.gl.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
public class SecurityConfig {

    // the username , password, role
    @Bean
    public UserDetailsService userDetailsService() {
        // create user for the spring boot in memory authentication
    	UserDetails user1 = User.withUsername("admin")
                .password("{noop}12345") 
                .roles("admin")
                .build();

    	UserDetails user2 = User.withUsername("student")
                .password("{noop}12345")
                .roles("student")        
                .build();
    	
    	UserDetails user3 = User.withUsername("principal")
                .password("{noop}12345")
                .roles("admin","student")        
                .build();
    	UserDetails user4 = User.withUsername("employee")
                .password("{noop}12345")
                .roles("employee")        
                .build();
        // added the users to the spring boot in memory
        return new InMemoryUserDetailsManager(user1, user2,user3, user4);
    }

    // Security filter chain for role-based URL protection
    @SuppressWarnings("removal")
	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
            	.requestMatchers("/global/**").permitAll()
                .requestMatchers("/admin/**").hasRole("admin")
                .requestMatchers("/student/**").hasRole("student")
                .requestMatchers("/general/**").hasAnyRole("admin", "student")// any one of the role
                .anyRequest().authenticated()
            )
            .httpBasic(); // enables basic authentication
            
        return http.build();
    }
}
