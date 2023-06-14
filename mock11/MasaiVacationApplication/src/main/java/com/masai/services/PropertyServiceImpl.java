package com.masai.services;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exception.PropertyException;
import com.masai.entities.Property;
import com.masai.repositories.PropertyRepository;

@Service
public class PropertyServiceImpl implements PropertyService {
	
	@Autowired
	
	private PropertyRepository prepo;

	@Override
	public Property addProperty(Property property) {
		
		return prepo.save(property);
	}

	@Override
	public List<Property> searchProperties(String location, Date startDate, Date endDate) {
		
		return prepo.findAll();
	}

	@Override
	public Property updateProperty(Long propertyId, Property updatedProperty) {
		
		 Property existingProperty = prepo.findById(propertyId).orElseThrow(() -> new PropertyException("Property dose not exist"));

	        existingProperty.setAddress(updatedProperty.getAddress());
	        existingProperty.setAmenities(updatedProperty.getAmenities());
	        existingProperty.setLocation(updatedProperty.getLocation());
	        existingProperty.setNumberOfRooms(updatedProperty.getNumberOfRooms());
	        existingProperty.setOwnerId(updatedProperty.getOwnerId());
	        existingProperty.setPropertyId(propertyId);
	        existingProperty.setPropertyType(updatedProperty.getPropertyType());
	        

	        return prepo.save(existingProperty);
	}

}
