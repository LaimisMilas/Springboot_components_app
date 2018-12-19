package iamus.net.components.project;

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
	public class ProjectController {
	
	

		@Autowired
		private ProjectService ProjectService;
		
		
		
		@RequestMapping("/projects")
		public List<Project> getAllProjects() {
			return  ProjectService.getAllProjects();
		}
		
		@RequestMapping("/projects/{id}")
		public Optional<Project> getProject(@PathVariable int id) {
			return ProjectService.getProject(id);
		}
		
		@RequestMapping(method=RequestMethod.POST, value="/projects", consumes = MediaType.APPLICATION_JSON_VALUE)
		public void addProject(@RequestBody Project project) {
			ProjectService.createProject(project);
		}
		
		@RequestMapping(method=RequestMethod.PUT, value="/projects/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
		public void updateProject(@RequestBody Project project, @PathVariable String id) {
			ProjectService.updateProject(project, id);
		}
		
		@RequestMapping(method=RequestMethod.DELETE, value="/projects/{id}")
		public void deleteProject(@PathVariable int id) {
			ProjectService.deleteProject(id);
		}
		
		@RequestMapping(method=RequestMethod.POST, value="/projects/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
		public void generateProject(@RequestBody Project project, @PathVariable String id) {
			ProjectService.generateProject(project);
		}
		
		
}
