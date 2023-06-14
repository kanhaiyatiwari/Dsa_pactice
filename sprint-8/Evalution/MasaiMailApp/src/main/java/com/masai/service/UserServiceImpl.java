package com.masai.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.InvalidInputException;
import com.masai.exceptions.UserNotFoundException;
import com.masai.models.Check;
import com.masai.models.Email;
import com.masai.models.User;
import com.masai.repository.UserDao;


@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	
	@Override
	public String registerUser(User user) throws InvalidInputException {
		// TODO Auto-generated method stub
		String str="User registration unsuccessful";
		
		try {
			
			userDao.save(user);
			str="User registration successful with id "+user.getEmail();
			
		}catch(Exception e) {
			
			throw new InvalidInputException(e.getMessage());
			
		}
		
		
		return str;
	}

	@Override
	public String loginUser(String email, String password) throws InvalidInputException {
		// TODO Auto-generated method stub
		String str="User login unsuccessful";
		
		User loggeduser=userDao.findByIdAndPassword(email, password);
		
		if(loggeduser!=null) {
			
			str="User login sucessful "+loggeduser.getFirstName();
		}else {
			
			throw new InvalidInputException(str);
		}

		return str;
	}

	
	@Override
	public String updateUser(User user) throws UserNotFoundException, InvalidInputException {
		// TODO Auto-generated method stub
		
		String str="User details not found";
		
		Optional<User> updateuser=userDao.findById(user.getEmail());
		
		if(updateuser.isEmpty()) {
			
			throw new UserNotFoundException(str);
			
		}else {
			
			
			try {
				
				userDao.save(user);
				str="User updated successfully with id "+user.getEmail();
				
			}catch(Exception e){
				
				throw new InvalidInputException(e.getMessage());
				
			}
			
			
		}
		
		
		
		
		return str;
	}

	@Override
	public List<Email> checkReceivedMails(String email) throws UserNotFoundException{
		// TODO Auto-generated method stub
		
		Optional<User> recmails=userDao.findById(email);
		
		List<Email> mails=new ArrayList<>();
		
		if(recmails.isEmpty()) {
			
			throw new UserNotFoundException("User details not found");
			
		}else {
			
			mails=recmails.get().getReceivedmails();
			
		}
		
		
		return mails;
	}

	@Override
	public List<Email> checkAllStarredMails(String email) throws UserNotFoundException{
		// TODO Auto-generated method stub
		
        Optional<User> recmails=userDao.findById(email);
		
		List<Email> mails=new ArrayList<>();
		
		
		if(recmails.isEmpty()) {
			
			throw new UserNotFoundException("User details not found");
			
		}else {
			
			mails=recmails.get().getReceivedmails();
			
		
			for(int i=0;i<mails.size();i++) {
				
				if(mails.get(i).getStarred()==Check.NO) {mails.remove(i);}
				
			}
			
			
		}
		
	
		
		
		return mails;
	}

	@Override
	public User signUp(User user) {
		// TODO Auto-generated method stub
		
		Optional<User> opt = userDao.findById(user.getEmail());
		if(opt.isPresent()) {
			throw new UserNotFoundException("user already exist with this email ");
		}else {
			return userDao.save(user);
		}
	
		
		
	}

}
