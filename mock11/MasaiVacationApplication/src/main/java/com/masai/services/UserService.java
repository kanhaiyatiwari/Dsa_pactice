package com.masai.services;

import com.masai.entities.User;

public interface UserService {
	
	User registerUser(User user);
	
    User loginUser(String email, String password);
	
	

}
