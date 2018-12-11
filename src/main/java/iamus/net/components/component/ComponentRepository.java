package iamus.net.components.component;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import iamus.net.components.property.Property;



public interface ComponentRepository extends CrudRepository <Component, String> {

	Optional<Component> findById(int id);
	@Transactional
	Optional<Component> deleteById(int id);

	@Query(value = "FROM Component c WHERE \n" +
		    "c.name LIKE %:searchTerm% " )
		    List<Component> findBySearchTermNative(@Param("searchTerm") String searchTerm);
}
