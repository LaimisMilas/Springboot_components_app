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
import org.apache.velocity.exception.ResourceNotFoundException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.MethodInvocationException;

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
		String repository = "C:\\Users\\Inspiron\\git\\Springboot_components_app\\src\\main\\java\\iamus\\net\\components\\generated\\";
		String templateText = "";
		
		File f = new File(repository+project.getName());
		f.mkdir();
		
		for(int i = 0; i<project.getModules().size(); i++) {
			//Creates Files for every Project->Module
			File file = new File(repository+project.getName()+"\\"+Utils.nameToUpperCase(project.getModules().get(i).getName())+".java");
			
			for(int j = 0; j<project.getModules().get(i).getTemplates().size(); j++) {
				//Gets text from all Module->Templates
				templateText += project.getModules().get(i).getTemplates().get(j).getText();
			}
			
			try {
				file.createNewFile();
				templateText = templateText.replaceAll("ProjectName", project.getName());
				templateText = templateText.replaceAll("ComponentName", Utils.nameToUpperCase(project.getModules().get(i).getComponent().getName()));
				templateText = templateText.replaceAll("lowerName", project.getModules().get(i).getComponent().getName());
				FileWriter fr = new FileWriter(file);
				fr.write(templateText);
				fr.close();
				// Resets template text
				templateText = "";
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		
//		Velocity.init();
//		
//		VelocityContext context = new VelocityContext();
//		
//		context.put( "CompName", project.getName() );
//
//		Template template = null;
//
//		try
//		{
//			
//		  template = Velocity.getTemplate(f1.getName()+".vm");
//		}
//		catch( ResourceNotFoundException rnfe )
//		{
//		  // couldn't find the template
//		}
//		catch( ParseErrorException pee )
//		{
//		  // syntax error: problem parsing the template
//		}
//		catch( MethodInvocationException mie )
//		{
//		  // something invoked in the template
//		  // threw an exception
//		}
//		catch( Exception e )
//		{}
//
//		StringWriter sw = new StringWriter();
//
//		template.merge( context, sw );
//		System.out.println(sw.toString());
	}

}
