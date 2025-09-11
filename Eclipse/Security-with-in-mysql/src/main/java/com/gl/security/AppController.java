package com.gl.security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
	@GetMapping("/admin/list")
	public String adminList() {
	    return "I am admin list";
	}
	@GetMapping("/student/list")
	public String studentList() {
	    return "I am student list";
	}

}
