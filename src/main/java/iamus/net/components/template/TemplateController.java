package iamus.net.components.template;

import java.io.File;
import java.io.IOException;
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

import iamus.net.components.component.Component;

	@CrossOrigin
	@RestController
	@RequestMapping("/api")
	public class TemplateController {
	
	

		@Autowired
		private TemplateService TemplateService;
		
		
		@RequestMapping(method=RequestMethod.POST,  value="/components/{id}/{name}", consumes = MediaType.APPLICATION_JSON_VALUE)
		public void generateFiles(@RequestBody Component component, @PathVariable String name, @PathVariable int id)	{

			String path = "C:\\Users\\Inspiron\\Desktop\\spring-boot\\demo\\src\\main\\java\\iamus\\net\\components\\generated";
			
			new File(path).mkdirs();
			new File(path+"\\"+name).mkdirs();
		
			File file1 = new File(path+"\\"+name+"\\"+name+".java");
			try {
				file1.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			File file2 = new File(path+"\\"+name+"\\"+name+"Controller.java");
			try {
				file2.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			File file3 = new File(path+"\\"+name+"\\"+name+"Repository.java");
			try {
				file3.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			File file4 = new File(path+"\\"+name+"\\"+name+"Service.java");
			try {
				file4.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		
		@RequestMapping("/Templates")
		public List<Template> getAllTemplates() {
			return  TemplateService.getAllTemplates();
		}
		
		@RequestMapping("/Templates/{id}")
		public Optional<Template> getTemplate(@PathVariable int id) {
			return TemplateService.getTemplate(id);
		}
//		@RequestMapping("/Templates/search={id}")
//		public List<Template> getTemplates(@PathVariable String id) {
//			return TemplateService.getTemplates(id);
//		}
		
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
