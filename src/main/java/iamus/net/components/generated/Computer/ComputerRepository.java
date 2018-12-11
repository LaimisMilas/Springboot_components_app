package iamus.net.components.generated.Computer;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import iamus.net.components.property.Property;
import iamus.net.components.component.Component;



public interface ComputerRepository extends CrudRepository <Computer, String> {

	Optional<Computer> findById(int id);
	@Transactional
	Optional<Computer> deleteById(int id);

	@Query(value = "FROM Computer c WHERE \n" +
		    "c.name LIKE %:searchTerm% " )
		    List<Computer> findBySearchTermNative(@Param("searchTerm") String searchTerm);
}
