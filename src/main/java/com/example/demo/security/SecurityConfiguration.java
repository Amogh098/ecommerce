package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
@EnableWebSecurity

public class SecurityConfiguration {
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}	
	
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf->csrf.disable())
		.authorizeHttpRequests(auth -> {	
				try {
					auth.requestMatchers(HttpMethod.DELETE,"/products/**").hasRole("ADMIN")
					.requestMatchers(HttpMethod.POST,"/products").hasRole("ADMIN")
					.requestMatchers(HttpMethod.GET,"/users").permitAll()
					.requestMatchers(HttpMethod.POST,"/placeorders").hasRole("USER")	
					.anyRequest().permitAll()
					.and().httpBasic();
				} catch (Exception e) {
					e.printStackTrace();
				}		
		});		
		return http.build();
	}
	
	@Autowired
	private MyUserDetailsService myUserDetailsService;
	
	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(myUserDetailsService);
	}
}
