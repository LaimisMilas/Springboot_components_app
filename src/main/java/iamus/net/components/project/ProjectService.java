package iamus.net.components.project;

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
public class ProjectService {

	@Autowired
	public ProjectRepository ProjectRepository;

	public List<Project> getAllProjects() {

		List<Project> Projects = new ArrayList<>();
		ProjectRepository.findAll().forEach(Projects::add);
		return Projects;
	}

	public Optional<Project> getProject(int id) {
		return ProjectRepository.findById(id);
	}

	public void updateProject(Project project, String id) {
		ProjectRepository.save(project);

	}

	public void deleteProject(int id) {

		ProjectRepository.deleteById(id);
	}

	public void createProject(Project project) {
		ProjectRepository.save(project);

	}
	
	public void generateProject(Project project) {
		File f = new File("C:\\Users\\Inspiron\\git\\Springboot_components_app\\src\\main\\java\\iamus\\net\\components\\generated");
	}

}
