package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.models.Email;

public interface EmailDao extends JpaRepository<Email, Integer> {

}
