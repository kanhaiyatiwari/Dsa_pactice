package com.masai.entities;

import com.masai.enums.Amenities;
import com.masai.enums.PropertyType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
@Data
@Entity
public class Property {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long propertyId;
	    
	    private Long ownerId;
	    
	    @NotNull(message = "Property type is required")
	    @NotBlank(message = "Property type is required")
	    @NotEmpty(message = "Property type is required" )
	    @Enumerated(EnumType.STRING)
	    private PropertyType propertyType;
	    
	    @NotBlank(message = "Address is required")
	    @NotNull(message = "Address is required ")
	    @NotEmpty(message = "Address is required" )
	    private String address;
	    
	    @Min(value = 1, message = "Number of rooms must be at least 1")
	    private int numberOfRooms;
	    
	    @NotBlank(message = "Location is required")
	    @NotNull(message = "Location is required ")
	    @NotEmpty(message = "Location is required" )
	    private String location;
	    
	    @NotNull(message = "Amenities are required")
	    @NotBlank(message = "Amenities is required")
	    @NotEmpty(message = "Amenities is required" )
	    @Enumerated(EnumType.STRING)
	    private Amenities amenities;

		

}
