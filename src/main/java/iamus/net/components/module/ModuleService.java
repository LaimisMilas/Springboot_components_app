package iamus.net.components.module;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import iamus.net.components.Utils;

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

	public void generateModule(Module module) {
		File dir = new File(
				"C:\\Users\\Inspiron\\git\\Springboot_components_app\\src\\main\\java\\iamus\\net\\components\\generated\\"
						+ module.getComponent().getName());
		dir.mkdir();
		File f = new File(
				"C:\\Users\\Inspiron\\git\\Springboot_components_app\\src\\main\\java\\iamus\\net\\components\\generated\\"
						+ module.getComponent().getName() + "\\" + Utils.nameToUpperCase(module.getName()));
		try {
			FileWriter fr = new FileWriter(
					"C:\\Users\\Inspiron\\git\\Springboot_components_app\\src\\main\\java\\iamus\\net\\components\\generated\\"
							+ module.getComponent().getName() + "\\" + Utils.nameToUpperCase(module.getName()));
			
			module.getTemplates().forEach(val -> {
				try {
					fr.write(val.getText());
				} catch (IOException e) {
					e.printStackTrace();
				}	
			});
			fr.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}
