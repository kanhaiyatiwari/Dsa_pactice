package com.masai.controllers;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.entities.Property;
import com.masai.services.PropertyService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/vacation")
public class PropertController {
	
	@Autowired
	private PropertyService ps;
	
	    @PostMapping("/properties")
	    
	    public ResponseEntity<Property> addProperty( @Valid @RequestBody Property property) {
	        Property addedProperty = ps.addProperty(property);
	        return new ResponseEntity<Property>(addedProperty,HttpStatus.OK);
	    }

	    @GetMapping("/properties")
	    public ResponseEntity<List<Property>> searchProperties( @Valid @RequestParam String location,
	                                                           @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
	                                                           @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
	        List<Property> properties = ps.searchProperties(location, startDate, endDate);
	        return new ResponseEntity<>(properties,HttpStatus.OK);
	    }
	    
	    @PutMapping("/properties/{propertyId}")
	    public ResponseEntity<Property> updateProperty( @Valid @PathVariable Long propertyId, @RequestBody Property updatedProperty) {
	       
	    	Property prop = ps.updateProperty(propertyId, updatedProperty);
	    	return new ResponseEntity<Property>(prop,HttpStatus.OK);
	    }

}
