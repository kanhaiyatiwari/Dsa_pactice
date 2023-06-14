package com.masai.modles;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Fir {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String crimeDetail   ;
	private LocalDateTime timeStamp ;
	private User applicant ;
	@OneToMany(cascade=CascadeType.ALL)
	private List<User> criminals;
	private Police officer ;
	private  PoliceStation policeStation ;
	private boolean isOpen ;

}
