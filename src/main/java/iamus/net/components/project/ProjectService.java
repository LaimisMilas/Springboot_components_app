package iamus.net.components.project;

import java.io.File;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import java.io.StringWriter;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.Template;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.MethodInvocationException;

import iamus.net.components.Utils;
import iamus.net.components.module.Module;
import iamus.net.components.property.Property;

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
		String repository = "C:\\Users\\Inspiron\\git\\Springboot_components_app\\src\\main\\java\\iamus\\net\\components\\generated\\";
		String templateText = "";

		File f = new File(repository + project.getName());
		f.mkdir();

		for (int i = 0; i < project.getModules().size(); i++) {

			String moduleName = project.getModules().get(i).getName();
			Module module = project.getModules().get(i);

			File mod = new File(repository + project.getName() + "\\"
					+ Utils.nameToLowerCase(moduleName));
			mod.mkdir();

			for (int j = 0; j < module.getTemplates().size(); j++) {

				String templateName = project.getModules().get(i).getTemplates().get(j).getName();
				
				templateName = templateName.replaceAll("Component", module.getComponent().getName());
				
				String filepath = "./src/main/java/iamus/net/components/generated/" + project.getName() + "/" + Utils.nameToLowerCase(moduleName) + "/"
						+ Utils.nameToUpperCase(templateName) + ".java";
				
				File temp = new File(filepath);
				templateText = project.getModules().get(i).getTemplates().get(j).getText();

				try {
					temp.createNewFile();
					FileWriter fr = new FileWriter(temp);
					fr.write(templateText);
					fr.close();
					
					VelocityEngine velocityEngine = new VelocityEngine();
			    	velocityEngine.init();
			    	    
			    	Template t = velocityEngine.getTemplate(filepath);
			    	     
			    	VelocityContext context = new VelocityContext();
			    	context.put("project", project);
			    	context.put("properties", module.component.getProperties());
			    	context.put("module", module);
			    	context.put("component", module.getComponent());
			    	context.put("upper", Utils.nameToUpperCase(module.component.getName()));
			    	context.put("lower", Utils.nameToLowerCase(module.component.getName()));
			    	context.put("Utils", Utils.class);
			    	
			    	FileWriter fileWriter = new FileWriter(temp);
			    	StringWriter StringWriter = new StringWriter();
			    	t.merge( context, StringWriter );
			    	
			    	fileWriter.write(StringWriter.toString());
			    	fileWriter.close();

				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}

		 
	}

}
