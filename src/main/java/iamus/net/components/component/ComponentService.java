package iamus.net.components.component;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iamus.net.components.property.Property;



@Service
public class ComponentService {
	
	@Autowired
	public ComponentRepository componentRepository;
	
	public List <Component> getAllComponents() {
		
		List <Component> components = new ArrayList<>();
		 componentRepository.findAll()
		 .forEach(components::add);			
		 return components;
	}
	
		public List<Component> getComponents(String id) {
		
		List <Component> components = new ArrayList<>();
		 componentRepository.findBySearchTermNative(id)
		.forEach(components::add);
		return components;
	}
	
	
	public Optional<Component> getComponent(int id) {
		return componentRepository.findById(id);
	}
	

	public void createComponent(Component component) {
		componentRepository.save(component);
	}

	public void updateComponent(Component component, String id) {
		componentRepository.save(component); 
		
	}

	public void deleteComponent(int id) {
		
		componentRepository.deleteById(id);
	}
	
}
