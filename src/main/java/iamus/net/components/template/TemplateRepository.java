package iamus.net.components.template;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import iamus.net.components.template.Template;



public interface TemplateRepository extends CrudRepository <Template, String> {

	Optional<Template> findById(int id);
	@Transactional
	Optional<Template> deleteById(int id);

	
}
