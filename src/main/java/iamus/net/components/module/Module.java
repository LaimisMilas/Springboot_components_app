package iamus.net.components.module;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import iamus.net.components.template.Template;

@Entity
public class Module {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	String name; 
	
	@OneToMany
	List<Template> templates = new ArrayList<>();
	
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
	
		public Module () {
		
	}
	
	public Module(String name, int id, List<Template> templates) {
		super();
		this.name = name;
		this.id = id;
		this.templates = templates;
	}
	
	
}
