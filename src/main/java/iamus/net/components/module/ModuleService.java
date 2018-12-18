package iamus.net.components.module;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModuleService {

	@Autowired
	public ModuleRepository ModuleRepository;

	public List<Module> getAllModules() {

		List<Module> Modules = new ArrayList<>();
		ModuleRepository.findAll().forEach(Modules::add);
		return Modules;
	}

	public Optional<Module> getModule(int id) {
		return ModuleRepository.findById(id);
	}

	public void updateModule(Module module, String id) {
		ModuleRepository.save(module);

	}

	public void deleteModule(int id) {

		ModuleRepository.deleteById(id);
	}

	public void createModule(Module module) {
		ModuleRepository.save(module);

	}


}
