package iamus.net.components.property;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

	@CrossOrigin
	@RestController
	@RequestMapping("/api")
	public class PropertyController {
	
	
		
		@Autowired
		private PropertyService propertyService;
		
		
		@RequestMapping("/properties")
		public List<Property> getAllProperties() {
			return  propertyService.getAllProperties();
		}
		
		@RequestMapping("/properties/{id}")
		public Optional<Property> getProperty(@PathVariable int id) {
			return propertyService.getProperty(id);
		}
		@RequestMapping("/properties/search={id}")
		public List<Property> getProperties(@PathVariable String id) {
			return propertyService.getProperties(id);
		}
		
		@RequestMapping(method=RequestMethod.POST, value="/properties", consumes = MediaType.APPLICATION_JSON_VALUE)
		public void addProperties(@RequestBody Property property) {
			propertyService.createProperty(property);
		}
		
		@RequestMapping(method=RequestMethod.PUT, value="/properties/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
		public void updateProperty(@RequestBody Property property, @PathVariable String id) {
			propertyService.updateProperty(property, id);
		}
		
		@RequestMapping(method=RequestMethod.DELETE, value="/properties/{id}")
		public void deleteProperty(@PathVariable int id) {
			propertyService.deleteProperty(id);
		}
	
}
