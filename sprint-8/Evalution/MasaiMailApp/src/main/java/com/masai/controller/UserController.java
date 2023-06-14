package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.models.Email;
import com.masai.models.User;
import com.masai.service.UserService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired(required=true)
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("/SignUp")
	public ResponseEntity<User> signUpAdminHandler(@Valid @RequestBody User user)  {
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		User savedUser = userService.signUp(user);

		return new ResponseEntity<User>(savedUser, HttpStatus.OK);
	}
	
	
	@PostMapping("/login")
	public ResponseEntity<String> loginUsear(){
		String str = "User logged in successfully ";
		return new ResponseEntity<String>(str, HttpStatus.OK);
	}

	
	
	

	
	@GetMapping("/masaimail/mail/{email}")
	public ResponseEntity<List<Email>> checkReceivedHandler(@Valid @PathVariable String email){
		
		List<Email> receivedmails=userService.checkReceivedMails(email);
		
		return new ResponseEntity<List<Email>>(receivedmails,HttpStatus.OK);
		
	}
	
	@GetMapping("/masaimail/starred/{email}")
	public ResponseEntity<List<Email>> checkStarredHandler(@Valid@PathVariable String email){
		
		List<Email> starredmails=userService.checkAllStarredMails(email);
		
		return new ResponseEntity<List<Email>>(starredmails,HttpStatus.OK);
		
	}
	
	@PutMapping("masaimail/user")
	public ResponseEntity<String> updateuserHandler(@Valid @RequestBody User user){
		
		String str=userService.updateUser(user);
		
		return new ResponseEntity<String>(str,HttpStatus.OK);
	
		
	}
	
	
	
	
}
