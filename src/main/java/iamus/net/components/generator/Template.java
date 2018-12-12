package iamus.net.components.generator;

import java.io.FileWriter;
import java.io.IOException;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Type;

import iamus.net.components.Utils;
import iamus.net.components.component.Component;

@Entity
public class Template {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	@OneToOne
	private Component component;
	@Type(type="text")
	String componentTemplate;
	@Type(type="text")
	String controllerTemplate;
	@Type(type="text")
	String repositoryTemplate;
	@Type(type="text")
	String serviceTemplate;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComponentTemplate() {
		return componentTemplate;
	}

	public void setComponentTemplate(String componentTemplate) {
		this.componentTemplate = componentTemplate;
	}

	public String getControllerTemplate() {
		return controllerTemplate;
	}

	public void setControllerTemplate(String controllerTemplate) {
		this.controllerTemplate = controllerTemplate;
	}

	public String getRepositoryTemplate() {
		return repositoryTemplate;
	}

	public void setRepositoryTemplate(String repositoryTemplate) {
		this.repositoryTemplate = repositoryTemplate;
	}

	public String getServiceTemplate() {
		return serviceTemplate;
	}

	public void setServiceTemplate(String serviceTemplate) {
		this.serviceTemplate = serviceTemplate;
	}
	
	public Component getComponent() {
		return component;
	}
	
	public void setComponent(Component component) {
		this.component = component;
	}

	public Template() {
		
	}

	public Template(int id, Component component, String componentTemplate, String controllerTemplate,
			String repositoryTemplate, String serviceTemplate) {
		super();
		this.id = id;
		this.component = component;
		this.componentTemplate = componentTemplate;
		this.controllerTemplate = controllerTemplate;
		this.repositoryTemplate = repositoryTemplate;
		this.serviceTemplate = serviceTemplate;
	}
	
	

	
}
