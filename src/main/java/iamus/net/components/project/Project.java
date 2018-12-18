package iamus.net.components.project;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import iamus.net.components.module.Module;

@Entity
public class Project {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	String name; 
	
	@ManyToMany(targetEntity = Module.class)
	List<Module> modules = new ArrayList<>();
	
	
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
	public List<Module> getModules() {
		return modules;
	}
	public void setModules(List<Module> modules) {
		this.modules = modules;
	}

		public Project () {
		
	}
	
	public Project(String name, int id, List<Module> modules) {
		super();
		this.name = name;
		this.id = id;
		this.modules = modules;
	}
	
	
}
