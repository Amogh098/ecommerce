package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {	
	@Autowired
	private UserService userService;
	@PostMapping("/register")
	public ResponseEntity<?> addUser(@RequestBody @Valid UserInput input){
		//call the service class method to add user to db
		User user=userService.addUser(input);
		return new ResponseEntity<>(user,HttpStatus.CREATED);
	}
}