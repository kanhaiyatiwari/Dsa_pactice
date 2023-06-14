package com.masai.SecurityConfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


public class ProjectSecurityConfig {

	@Bean
	public SecurityFilterChain securityConfig(HttpSecurity http) throws Exception {
	
	
		http.authorizeHttpRequests( (auth)->auth
				.requestMatchers("/user/SignUp").permitAll()
				.requestMatchers("/user/login").hasRole("user")
				.requestMatchers("/user/masaimail/mail/{email}").hasRole("user")
				.requestMatchers("/user/masaimail/starred/{email}").hasRole("user")
				.requestMatchers("/usermasaimail/user").hasRole("user")
		).csrf().disable()
		.httpBasic();
	
		return http.build();
}

	@Bean
	 public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	 }

	
}
