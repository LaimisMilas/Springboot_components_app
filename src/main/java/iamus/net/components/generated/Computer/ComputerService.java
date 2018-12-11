package iamus.net.components.generatedComputer;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iamus.net.components.property.Property;



@Service
public class ComputerService {
	
	@Autowired
	public ComputerRepository ComputerRepository;
	
	public List <Computer> getAllComputers() {
		
		List <Computer> Computer = new ArrayList<>();
		 ComputerRepository.findAll()
		 .forEach(Computers::add);			
		 return Computers;
	}
	
		public List<Computer> getComputers(String id) {
		
		List <Computer> Computers = new ArrayList<>();
		 ComputerRepository.findBySearchTermNative(id)
		.forEach(Computers::add);
		return Computers;
	}
	
	
	public Optional<Computer> getComputer(int id) {
		return ComputerRepository.findById(id);
	}
	

	public void createComputer(Computer Computer) {
		ComputerRepository.save(Computer);
	}

	public void updateComputer(Computer Computer, String id) {
		ComputerRepository.save(Computer); 
		
	}

	public void deleteComputer(int id) {
		
		ComputerRepository.deleteById(id);
	}
	
}
