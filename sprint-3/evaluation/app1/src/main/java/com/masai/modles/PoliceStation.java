package com.masai.modles;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
@Data
@Entity
public class PoliceStation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String stationCode ;
	private String address ;
	private Police officerInCharge ;
	private List<Police> constables ;
	private List<Fir> firList ;
}
