package com.gl.springboot;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {
	
	//http://localhost:8082/add?a=10&b=20
	@GetMapping("/add")
	public String add( @RequestParam int a,@RequestParam int b) {
		int c=a+b;
		return "Addition : " +c;
	}
	//http://localhost:8082/addnew?a=10&b=20
	@GetMapping("/addnew")
	public ResponseEntity<String> addnew(@RequestParam int a, @RequestParam int b) {
	    return ResponseEntity.status(HttpStatus.OK).body("Add: " + (a + b));
	}
	//http://localhost:8082/sub?a=10&b=50
	@GetMapping("/sub")
	public String sub( @RequestParam int a,@RequestParam int b) {
		int c=a-b;
		return "Sub : " +c;
	}
	//http://localhost:8082/subnew?a=70&b=50
	@GetMapping("/subnew")
	public ResponseEntity<String> subnew(@RequestParam int a, @RequestParam int b) {
	    if (b > a) {
	        return ResponseEntity
	                .status(HttpStatus.BAD_REQUEST)
	                .body("B must not be bigger than A");
	    } 
	        return ResponseEntity
	                .status(HttpStatus.OK)
	                .body("Sub: " + (a - b));
	    
	}
	//http://localhost:8082/mul/10/50
	@GetMapping("/mul/{a}/{b}")
	public String mul( @PathVariable int a,@PathVariable int b) {
		
		return "Mul : " +(a*b);
	}
	//http://localhost:8082/div/40/40
	@GetMapping("/div/{a}/{b}")
	public String div(@PathVariable int a, @PathVariable int b) {
	    
	    return "Quotient : " + (a / b);
	}
	
	//http://localhost:8082/divnew?a=10&b=5
	@GetMapping("/divnew")
	public ResponseEntity<String> divnew(@RequestParam int a, @RequestParam int b) {
	    if (b == 0) {
	        return ResponseEntity
	                .status(HttpStatus.BAD_REQUEST)
	                .body("Division by zero is not allowed!");
	    }
	    return ResponseEntity
	            .status(HttpStatus.OK)
	            .body("Div: " + ((double) a / b));
	}
	//http://localhost:8082/login/admin/1234
	@GetMapping("/login/{username}/{password}")
	public ResponseEntity<String> login(@PathVariable String username, @PathVariable String password) {
	    
	    
	    if ("admin".equals(username) && "1234".equals(password)) {
	        return ResponseEntity
	                .status(HttpStatus.OK)
	                .body("Login successful! Welcome " + username);
	    } else {
	        return ResponseEntity
	                .status(HttpStatus.UNAUTHORIZED)
	                .body("Invalid username or password");
	    }
	}



	
	
	
	
	

}
