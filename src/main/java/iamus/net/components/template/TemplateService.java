package iamus.net.components.template;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class TemplateService {
	
	@Autowired
	public TemplateRepository TemplateRepository;
	
	public List <Template> getAllTemplates() {
		
		List <Template> Templates = new ArrayList<>();
		 TemplateRepository.findAll()
		 .forEach(Templates::add);			
		 return Templates;
	}
	
	
	public Optional<Template> getTemplate(int id) {
		return TemplateRepository.findById(id);
	}

	public void updateTemplate(Template Template, String id) {
		TemplateRepository.save(Template); 
		
	}

	public void deleteTemplate(int id) {
		
		TemplateRepository.deleteById(id);
	}

	public void createTemplate(Template template) {
		TemplateRepository.save(template);
		
	}
	
}
