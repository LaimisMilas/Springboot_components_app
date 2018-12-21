package iamus.net.components.template;

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
	public class TemplateController {
	
	

		@Autowired
		private TemplateService TemplateService;
		
		
		
		@RequestMapping("/Templates")
		public List<Template> getAllTemplates() {
			return  TemplateService.getAllTemplates();
		}
		
		@RequestMapping("/Templates/{id}")
		public Optional<Template> getTemplate(@PathVariable int id) {
			return TemplateService.getTemplate(id);
		}
		
		@RequestMapping(method=RequestMethod.POST, value="/Templates", consumes = MediaType.APPLICATION_JSON_VALUE)
		public void addTemplate(@RequestBody Template template) {
			TemplateService.createTemplate(template);
		}
		
		@RequestMapping(method=RequestMethod.PUT, value="/Templates/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
		public void updateTemplate(@RequestBody Template Template, @PathVariable String id) {
			TemplateService.updateTemplate(Template, id);
		}
		
		@RequestMapping(method=RequestMethod.DELETE, value="/Templates/{id}")
		public void deleteTemplate(@PathVariable int id) {
			TemplateService.deleteTemplate(id);
		}
	
}
