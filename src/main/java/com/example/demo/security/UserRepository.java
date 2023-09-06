package com.example.demo.security;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;



public interface UserRepository extends CrudRepository<User, Integer> {
	
	@RestResource(exported = false)
	User save(User user);	
	@RestResource(exported = false)
	public Optional<User> findByEmail(String email);
	
}

