package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserService {	
	@Autowired
	private UserRepository userRepository; 	
	@Autowired
	private PasswordEncoder passwordEncoder;
	public User addUser(UserInput input) {
		//
		User user=new User();
		user.setName(input.getName());
		user.setEmail(input.getEmail());
		user.setRoles(input.getRoles());//
		user.setPassword(passwordEncoder.encode(input.getPassword()));		
		//call save of repository, to add user
		return userRepository.save(user);
	}
}

