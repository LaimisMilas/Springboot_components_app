package iamus.net.components.module;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import iamus.net.components.template.Template;



public interface ModuleRepository extends CrudRepository <Module, String> {

	Optional<Module> findById(int id);
	@Transactional
	Optional<Module> deleteById(int id);

	
}
