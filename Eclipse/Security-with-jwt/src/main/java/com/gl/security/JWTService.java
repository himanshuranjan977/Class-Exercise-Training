package com.gl.security;

import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JWTService {
	private final Key key;
    private final long expirationMs;
    
 // Moving values from application.properties/application.yml
    public JWTService(
            @Value("${app.jwt.secret}") String secret,
            @Value("${app.jwt.expiration-ms}") long expirationMs) {

        this.key = Keys.hmacShaKeyFor(secret.getBytes());
        this.expirationMs = expirationMs;
    }
    
    //generate new token [username, expiration time)
    
	public String generateToken(String username, Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username) // for whom
                .setIssuedAt(new Date()) // when we create it
                .setExpiration(new Date(System.currentTimeMillis() + expirationMs)) // when it will expire
                .signWith(key, SignatureAlgorithm.HS256) // signing the token
                .compact();
    }
	
	// Retrieve the claims / information inside the token
	public <T> T extractClaim(String token, Function<Claims, T> resolver) {
	    Claims claims = Jwts.parserBuilder()
	                        .setSigningKey(key) // your secret key
	                        .build()
	                        .parseClaimsJws(token)
	                        .getBody();
	    return resolver.apply(claims);
	}
    
    //extract username from the token
	public String extractUsername(String token) {
	    return extractClaim(token, Claims::getSubject);
	}
    
  
	//to check whether the token is expired not
	@SuppressWarnings("unused") 
	public boolean isTokenExpired(String token) {
	    Date expDate = extractClaim(token, Claims::getExpiration);
	    return expDate.before(new Date());
	}
	
	//token is valid or not
	public boolean isTokenValid(String token, String username) {
	    String usernameFromToken = extractUsername(token);
	    return usernameFromToken.equals(username);
	}
    
  




}
