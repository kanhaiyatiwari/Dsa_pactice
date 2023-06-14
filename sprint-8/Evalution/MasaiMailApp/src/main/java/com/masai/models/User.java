package com.masai.models;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@Id
	private String Email;
	@Pattern(regexp = "^[a-zA-Z]*$", message="firstname should be alphabetical")
	private String firstName;
	@Pattern(regexp = "^[a-zA-Z]*$", message="lastname should be alphabetical")
	private String lastname;
	@Pattern(regexp = "^\\d{10}$", message="mobile number should be 10 digits")
	private String mobileNumber;
	@Past(message="Enter proper dob details")
	private LocalDate dateOfBirth=LocalDate.now();
	@ManyToMany(mappedBy ="receiver",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<Email> Receivedmails;
	@OneToMany(mappedBy ="sender",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<Email> Sentmails;
	
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{6,12}$", message = "Password should be alpha-numberic-special")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String Password;
	
		
}
