package com.masai.modles;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
@Data
@Entity
public class Police {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int id;
	private String officerName;
	private String mobileNo ;
	private String department ;
	private List<Fir> firsFiled ;
	private List<Fir> casesClosed ;
}
