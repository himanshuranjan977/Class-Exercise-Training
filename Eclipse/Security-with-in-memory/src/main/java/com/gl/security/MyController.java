package com.gl.security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	
	@GetMapping("/admin/list")
	public String adminlist() {
		return "I am admin list";
	}
	@PostMapping("/admin/add")
	public String adminAdd() {
		return "I am admin add";
	}
	@GetMapping("/student/list")
	public String studentList() {
		return "I am student list";
	}
	@PostMapping("/student/add")
	public String studentAdd() {
		return "I am student add";
	}
	@GetMapping("/parent/list")
	public String parentList() {
		return "I am parent list";
	}
	@GetMapping("/general/contact")
	public String generalContact() {
		return "I am general contact";
	}
	@GetMapping("/global/welcome")
	public String globalWelcome() {
		return "I am Global Welcome";
	}

}
