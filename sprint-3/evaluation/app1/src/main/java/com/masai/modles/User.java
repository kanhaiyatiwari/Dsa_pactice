package com.masai.modles;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Data
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String firstName ;
	private String lastName   ;
	private String mobileNumber ;
	private String address  ;
	private int age;
	private String gender;
	private String password ;
	
}
