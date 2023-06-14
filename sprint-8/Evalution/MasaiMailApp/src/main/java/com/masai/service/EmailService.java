package com.masai.service;

import com.masai.exceptions.EmailNotFoundException;
import com.masai.exceptions.UserNotFoundException;
import com.masai.models.Email;

public interface EmailService {

	public String sendMail(Email mail) throws UserNotFoundException;
	
	public String starMail(Integer mailId) throws EmailNotFoundException;
	
	public String deleteMail(Integer mailId) throws EmailNotFoundException;
	
}
