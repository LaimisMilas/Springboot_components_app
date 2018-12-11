package iamus.net.components.generated.Template;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import iamus.net.components.property.Property;
import iamus.net.components.component.Component;



public interface TemplateRepository extends CrudRepository <Template, String> {

	Optional<Template> findById(int id);
	@Transactional
	Optional<Template> deleteById(int id);

	@Query(value = "FROM Template c WHERE \n" +
		    "c.name LIKE %:searchTerm% " )
		    List<Template> findBySearchTermNative(@Param("searchTerm") String searchTerm);
}
