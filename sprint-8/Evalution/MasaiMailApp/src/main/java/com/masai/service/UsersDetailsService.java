package com.masai.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.masai.exceptions.UserNotFoundException;
import com.masai.models.User;
import com.masai.models.UserLogin;
import com.masai.repository.UserDao;

@Service
public class UsersDetailsService implements UserDetailsService{

	@Autowired
	private UserDao userDao;
	@Override
	public UserDetails loadUserByUsername(String email) throws UserNotFoundException {
		Optional<User> opt = userDao.findById(email);
		if(opt.isEmpty()) {
			throw new UserNotFoundException("No user detail found with this username ");
		}else {
			return new UserLogin(opt.get());
		}
	}
	
}
