package iamus.net.components.generated.house;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import iamus.net.components.property.Property;
import iamus.net.components.component.Component;



public interface HouseRepository extends CrudRepository <House, String> {

	Optional<House> findById(int id);
	@Transactional
	Optional<House> deleteById(int id);

	@Query(value = "FROM House c WHERE \n" +
		    "c.name LIKE %:searchTerm% " )
		    List<House> findBySearchTermNative(@Param("searchTerm") String searchTerm);
}
