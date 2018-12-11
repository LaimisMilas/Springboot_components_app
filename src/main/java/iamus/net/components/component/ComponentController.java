package iamus.net.components.component;

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
	public class ComponentController {
	
	

		@Autowired
		private ComponentService componentService;
		
		
		@RequestMapping("/components")
		public List<Component> getAllComponents() {
			return  componentService.getAllComponents();
		}
		
		@RequestMapping("/components/{id}")
		public Optional<Component> getComponent(@PathVariable int id) {
			return componentService.getComponent(id);
		}
		@RequestMapping("/components/search={id}")
		public List<Component> getComponents(@PathVariable String id) {
			return componentService.getComponents(id);
		}
		
		@RequestMapping(method=RequestMethod.POST, value="/components", consumes = MediaType.APPLICATION_JSON_VALUE)
		public void addComponent(@RequestBody Component component) {
			componentService.createComponent(component);
		}
		
		@RequestMapping(method=RequestMethod.PUT, value="/components/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
		public void updateComponent(@RequestBody Component component, @PathVariable String id) {
			componentService.updateComponent(component, id);
		}
		
		@RequestMapping(method=RequestMethod.DELETE, value="/components/{id}")
		public void deleteComponent(@PathVariable int id) {
			componentService.deleteComponent(id);
		}
	
}
