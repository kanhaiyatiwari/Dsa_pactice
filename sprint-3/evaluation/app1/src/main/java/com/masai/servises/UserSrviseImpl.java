package com.masai.servises;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.modles.User;
import com.masai.repo.UserRepo;
@Service
public class UserSrviseImpl implements Userservise {
	@Autowired
private UserRepo userp;
	@Override
	public User addnewUser(User user) {
	
		return  userp.save(user);
	}

}
