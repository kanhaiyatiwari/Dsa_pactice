package com.masai.service;

import java.util.List;

import com.masai.exceptions.InvalidInputException;
import com.masai.exceptions.UserNotFoundException;
import com.masai.models.Email;
import com.masai.models.User;

public interface UserService {

	public String registerUser(User user) throws InvalidInputException;
	
	public String loginUser(String email,String password) throws InvalidInputException;
	
	public List<Email> checkReceivedMails(String email) throws UserNotFoundException;
	
	public List<Email> checkAllStarredMails(String email) throws UserNotFoundException;
	
	public String updateUser(User user) throws UserNotFoundException,InvalidInputException;
	
	public User signUp (User user) ;
	
}
