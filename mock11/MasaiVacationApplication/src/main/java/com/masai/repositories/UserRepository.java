package com.masai.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	
	
	User findByEmailAndPassword(String email, String password);

}
