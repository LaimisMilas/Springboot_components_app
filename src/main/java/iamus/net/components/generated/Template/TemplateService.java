package iamus.net.components.generatedTemplate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iamus.net.components.property.Property;



@Service
public class TemplateService {
	
	@Autowired
	public TemplateRepository TemplateRepository;
	
	public List <Template> getAllTemplates() {
		
		List <Template> Template = new ArrayList<>();
		 TemplateRepository.findAll()
		 .forEach(Templates::add);			
		 return Templates;
	}
	
		public List<Template> getTemplates(String id) {
		
		List <Template> Templates = new ArrayList<>();
		 TemplateRepository.findBySearchTermNative(id)
		.forEach(Templates::add);
		return Templates;
	}
	
	
	public Optional<Template> getTemplate(int id) {
		return TemplateRepository.findById(id);
	}
	

	public void createTemplate(Template Template) {
		TemplateRepository.save(Template);
	}

	public void updateTemplate(Template Template, String id) {
		TemplateRepository.save(Template); 
		
	}

	public void deleteTemplate(int id) {
		
		TemplateRepository.deleteById(id);
	}
	
}
