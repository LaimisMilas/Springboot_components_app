package iamus.net.components.generatedhouse;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iamus.net.components.property.Property;



@Service
public class HouseService {
	
	@Autowired
	public HouseRepository houseRepository;
	
	public List <House> getAllHouses() {
		
		List <House> house = new ArrayList<>();
		 houseRepository.findAll()
		 .forEach(houses::add);			
		 return houses;
	}
	
		public List<House> getHouses(String id) {
		
		List <House> houses = new ArrayList<>();
		 houseRepository.findBySearchTermNative(id)
		.forEach(houses::add);
		return houses;
	}
	
	
	public Optional<House> getHouse(int id) {
		return houseRepository.findById(id);
	}
	

	public void createHouse(House house) {
		houseRepository.save(house);
	}

	public void updateHouse(House house, String id) {
		houseRepository.save(house); 
		
	}

	public void deleteHouse(int id) {
		
		houseRepository.deleteById(id);
	}
	
}
