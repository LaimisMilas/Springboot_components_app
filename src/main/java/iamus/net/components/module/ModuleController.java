package iamus.net.components.module;

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
	public class ModuleController {
	
	

		@Autowired
		private ModuleService ModuleService;
		
		
		
		@RequestMapping("/Modules")
		public List<Module> getAllModules() {
			return  ModuleService.getAllModules();
		}
		
		@RequestMapping("/Modules/{id}")
		public Optional<Module> getModule(@PathVariable int id) {
			return ModuleService.getModule(id);
		}
		
		@RequestMapping(method=RequestMethod.POST, value="/Modules", consumes = MediaType.APPLICATION_JSON_VALUE)
		public void addModule(@RequestBody Module module, @PathVariable String name, @PathVariable int id) {
			ModuleService.createModule(module);
		}
		
		@RequestMapping(method=RequestMethod.PUT, value="/Modules/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
		public void updateModule(@RequestBody Module module, @PathVariable String id) {
			ModuleService.updateModule(module, id);
		}
		
		@RequestMapping(method=RequestMethod.DELETE, value="/Modules/{id}")
		public void deleteModule(@PathVariable int id) {
			ModuleService.deleteModule(id);
		}
	
}
