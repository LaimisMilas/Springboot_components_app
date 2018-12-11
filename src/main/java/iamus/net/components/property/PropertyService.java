package iamus.net.components.property;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class PropertyService {
	
	@Autowired
	public PropertyRepository propertyRepository;
	
	public List <Property> getAllProperties() {
		
		List <Property> properties = new ArrayList<>();
		propertyRepository.findAll()
		 .forEach(properties::add);			
		 return properties;
	}
	
		public List<Property> getProperties(String id) {
		
		List <Property> properties = new ArrayList<>();
		  propertyRepository.findBySearchTermNative(id)
		.forEach(properties::add);
		return properties;
	}
	
	public Optional<Property> getProperty(int id) {
		return propertyRepository.findById(id);
	}
	

	public void createProperty(Property property) {
		propertyRepository.save(property);
	}

	public void updateProperty(Property property, String id) {
		propertyRepository.save(property); 
		
	}

	public void deleteProperty(int id) {
		
		propertyRepository.deleteById(id);
	}
	
}
