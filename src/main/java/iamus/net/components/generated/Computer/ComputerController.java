package iamus.net.components.generated.Computer;

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
	public class ComputerController {
	
	

		@Autowired
		private Computer ComputerService;
		
		
		@RequestMapping("/Computers")
		public List<Computer> getAllComputers() {
			return  ComputerService.getAllComputers();
		}
		
		@RequestMapping("/Computers/{id}")
		public Optional<Computer> getComputer(@PathVariable int id) {
			return ComputerService.getComputer(id);
		}
		@RequestMapping("/Computers/search={id}")
		public List<Computer> getComputers(@PathVariable String id) {
			return ComputerService.getComputers(id);
		}
		
		@RequestMapping(method=RequestMethod.POST, value="/Computers", consumes = MediaType.APPLICATION_JSON_VALUE)
		public void addComputer(@RequestBody Computer Computer) {
			ComputerService.createComputer(Computer);
		}
		
		@RequestMapping(method=RequestMethod.PUT, value="/Computers/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
		public void updateComputer(@RequestBody Computer Computer, @PathVariable String id) {
			ComputerService.updateComputer(Computer, id);
		}
		
		@RequestMapping(method=RequestMethod.DELETE, value="/Computers/{id}")
		public void deleteComputer(@PathVariable int id) {
			ComputerService.deleteComputer(id);
		}
	
}
