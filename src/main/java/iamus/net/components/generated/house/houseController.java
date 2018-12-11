package iamus.net.components.generated.house;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

	@CrossOrigin
	@RestController
	@RequestMapping("/api")
	public class HouseController {
	
	

		@Autowired
		private House houseService;
		
		
		@RequestMapping("/houses")
		public List<House> getAllHouses() {
			return  houseService.getAllHouses();
		}
		
		@RequestMapping("/houses/{id}")
		public Optional<House> getHouse(@PathVariable int id) {
			return houseService.getHouse(id);
		}
		@RequestMapping("/houses/search={id}")
		public List<House> getHouses(@PathVariable String id) {
			return houseService.getHouses(id);
		}
		
		@RequestMapping(method=RequestMethod.POST, value="/houses", consumes = MediaType.APPLICATION_JSON_VALUE)
		public void addHouse(@RequestBody House house) {
			houseService.createHouse(house);
		}
		
		@RequestMapping(method=RequestMethod.PUT, value="/houses/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
		public void updateHouse(@RequestBody House house, @PathVariable String id) {
			houseService.updateHouse(house, id);
		}
		
		@RequestMapping(method=RequestMethod.DELETE, value="/houses/{id}")
		public void deleteHouse(@PathVariable int id) {
			houseService.deleteHouse(id);
		}
	
}
