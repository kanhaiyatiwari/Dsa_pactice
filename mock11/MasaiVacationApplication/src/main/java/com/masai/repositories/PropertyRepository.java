package com.masai.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.entities.Property;


public interface PropertyRepository extends JpaRepository<Property, Long> {

}
