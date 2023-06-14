package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.models.Email;
import com.masai.service.EmailService;

@RestController
public class EmailController {

	@Autowired
	private EmailService emailService;
	
	@PostMapping("/masaimail/mail")
	public ResponseEntity<String> sensMailHandler( @Valid @RequestBody Email mail){
		
		String str=emailService.sendMail( mail);
		
		return new ResponseEntity<String>(str,HttpStatus.OK);
		
	}
	
	@PostMapping("/masaimail/starred/{id}")
	public ResponseEntity<String> starredMailController( @Valid @PathVariable Integer id){
		
		
		String str=emailService.starMail(id);
		
		return new ResponseEntity<String>(str,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/masaimail/delete/{id}")
	public ResponseEntity<String> deleteMailController(@Valid @PathVariable Integer id){
		
		String str=emailService.deleteMail(id);
		
		return new ResponseEntity<String>(str,HttpStatus.OK);
		
	}
	
	
}
