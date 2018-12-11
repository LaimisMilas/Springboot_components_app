package iamus.net.components.property;

import iamus.net.components.component.Component;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Property {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String type;
	
	@ManyToMany(targetEntity=Component.class,
				mappedBy="properties")
	private List<Component> components = new ArrayList<>();
	
	
	public List<Component> getComponents() {
				List<Component> newComponents = new ArrayList<>();
				 this.components.forEach(val -> {
					 Component comp = new Component();
					 comp.setId(val.getId());
					 comp.setName(val.getName());
					 newComponents.add(comp);
				 });
				 
				 return newComponents;
	}
	public void setComponents(List<Component> components) {
		this.components = components;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public Property( ) {
		
	}
	public Property(int id, String name, String type, List<Component> components) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.components = components;
	}
	
	
	
	
}
