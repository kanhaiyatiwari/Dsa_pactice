package com.masai.entities;

import com.masai.enums.Gender;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    
    @NotBlank(message = "nameme is required")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "Name must only contain alphabets and spaces")
    private String name;
    
    @NotBlank(message = "Email  must  required")
    @Email(message = "Invalid email format")
    private String email;
    
    @Min(value = 16, message = "age must be above 15")
    private int age;
    
    @NotBlank(message = "Password must be required")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,12}$", message = "Password must contain 6-12 characters with at least one uppercase letter, one lowercase letter, one digit, and one special character.")
    private String password;
    
    @NotBlank(message = "number is required")
    private String phone;
    
    @NotBlank(message = "Address is required")
    private String address;
    @Enumerated(EnumType.STRING)
    private Gender gender;
	
	}
