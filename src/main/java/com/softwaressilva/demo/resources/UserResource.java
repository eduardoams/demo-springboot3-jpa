package com.softwaressilva.demo.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softwaressilva.demo.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@GetMapping
	public ResponseEntity<User> findAll() {
		User u = new User(1L, "Eduardo Souza", "eduardoa.ms14@gmail.com", "(11) 91234-5678", "123456");
		return ResponseEntity.ok().body(u);
	}
}
