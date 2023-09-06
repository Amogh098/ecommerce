package com.example.demo.security;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



import jakarta.transaction.Transactional;

@Service
@Transactional

public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		return userRepository.findByEmail(email)
				.map(user->{
					User dbUser=new User(
							user.getEmail(),
							user.getPassword(),
							user.getRoles()
								.stream()
								.map(role->new SimpleGrantedAuthority(role))
								.collect(Collectors.toList())
							);
					return dbUser;
				})					
				.orElseThrow(()->new UsernameNotFoundException("Email is inavlid"));
	}}


