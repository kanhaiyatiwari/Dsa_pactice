package com.masai.entities;

import java.sql.Date;

import com.masai.enums.ReservationStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class Reservation {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long reservationId;
	    
	    private Long userId;
	    
	    private Long propertyId;
	    
	    @NotNull(message = "Start date is required")
	    @NotBlank(message = "Start date is required")
	    @NotEmpty(message = "Start date is required")
	    private Date startDate;
	    
	    @NotNull(message = "End date is required")
	    @NotBlank(message = "End date is required")
	    @NotEmpty(message = "End date is required")
	    private Date endDate;
	    
	   
	    private int numberOfGuests;
	    
	    private double totalPrice;
	    
	    
	    @Enumerated(EnumType.STRING)
	    
	    private ReservationStatus status;
	    

}
