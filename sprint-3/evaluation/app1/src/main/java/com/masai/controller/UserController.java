package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.modles.User;
import com.masai.servises.Userservise;

@RestController
public class UserController {
	
	@Autowired
	private Userservise us;
	
	
	@PostMapping("/departments")
	public ResponseEntity<User> addNewUser(@RequestBody User user){
		User save= us.addnewUser(user);
		return new ResponseEntity<>(save, HttpStatus.CREATED);
	}

}
