package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.masai.models.User;

public interface UserDao extends JpaRepository<User, String>{

	@Query("FROM User u WHERE u.Email = ?1 AND u.Password = ?2")
	User findByIdAndPassword(String email,String password);
	
	
}
