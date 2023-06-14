package com.masai.models;

import java.util.List;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Email {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String email_id;
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private User sender;
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<User> receiver;
	private String message;
	private Check starred=Check.NO;
	private Check Deleted=Check.NO;
	
	
	
}
