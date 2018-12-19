package iamus.net.components.module;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;



import iamus.net.components.component.Component;

import iamus.net.components.template.Template;

@Entity
public class Module {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	String name; 
	
	@ManyToMany(targetEntity = Template.class)
	List<Template> templates = new ArrayList<>();
	
	@OneToOne
	public Component component;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Template> getTemplates() {
		return templates;
	}
	public void setTemplates(List<Template> templates) {
		this.templates = templates;
	}
	
	public Component getComponent() {
		return component;

	}
	public void setComponent(Component component) {
		this.component = component;
	}
		public Module () {
		
	}
	
	public Module(String name, int id, List<Template> templates, Component component) {
		super();
		this.name = name;
		this.id = id;
		this.templates = templates;
		this.component = component;
	}
	
	
}
