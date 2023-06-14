package com.masai.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.modles.User;

public interface UserRepo  extends JpaRepository<User, Integer>{

}
