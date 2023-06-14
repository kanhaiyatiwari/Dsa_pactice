package com.masai.services;

import java.sql.Date;
import java.util.List;

import com.masai.entities.Property;

public interface PropertyService {
	
	Property addProperty(Property property);
	
    List<Property> searchProperties(String location, Date startDate, Date endDate);
    
    public Property updateProperty(Long propertyId, Property updatedProperty);

}
