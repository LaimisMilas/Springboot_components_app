package iamus.net.components.property;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;



public interface PropertyRepository extends CrudRepository<Property, String> {

	Optional<Property> findById(int id);
	@Transactional
	Optional<Property> deleteById(int id);
	
	
	@Query(value = "FROM Property p WHERE \n" +
		    "p.name LIKE %:searchTerm% OR "  + 
		    "p.type LIKE %:searchTerm%  " )
		    List<Property> findBySearchTermNative(@Param("searchTerm") String searchTerm);

}
