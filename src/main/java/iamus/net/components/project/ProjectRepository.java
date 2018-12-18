package iamus.net.components.project;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import iamus.net.components.template.Template;



public interface ProjectRepository extends CrudRepository <Project, String> {

	Optional<Project> findById(int id);
	@Transactional
	Optional<Project> deleteById(int id);

	
}
