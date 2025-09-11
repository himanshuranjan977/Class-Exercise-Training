package com.gl.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JWTAuthFilter extends OncePerRequestFilter{
	@Autowired
	JWTService jwtService;
	
	@Autowired
	CustomUserDetailService customUserDetailService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// validate the token
		//read the token from authorization head

		String authHeader = request.getHeader("Authorization");
		//sample token --> Bearer :
		if (authHeader == null || !authHeader.startsWith("Bearer ")) {
		    filterChain.doFilter(request, response);
		    return; // stop further processing
		}
		String jwt = authHeader.substring(7);
		String username =jwtService.extractUsername(jwt);
		
		//there must be some user name
		if(username !=null) {
			UserDetails userDetails = customUserDetailService.loadUserByUsername (username);
			
			if (jwtService.isTokenValid(jwt, userDetails.getUsername()) && !jwtService.isTokenExpired(jwt)) {
				//authToken from the jwtToken
				//forwarding the control to the controller
				UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
				userDetails, null, userDetails.getAuthorities());
				authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				//we will read this authToken from this context in the controllers files
				SecurityContextHolder.getContext().setAuthentication(authToken);
			}
			

		}
	    filterChain.doFilter(request, response);
	    return; // stop further processing
		
	}


}
