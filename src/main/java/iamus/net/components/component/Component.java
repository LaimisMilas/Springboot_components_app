package iamus.net.components.component;

import java.util.ArrayList;
import java.util.List;

import iamus.net.components.module.Module;
import iamus.net.components.property.Property;
import iamus.net.components.template.Template;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
public class Component {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;

	@ManyToMany(targetEntity=Property.class)
	private List<Property> properties = new ArrayList<>();
	
	
	
	
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
	
	public List<Property> getProperties() {
				return properties;
	}
	public void setProperties(List<Property> properties) {
		this.properties = properties;
	}
	
	
	public Component() {
		
	}
	
	public Component(int id, String name, List<Property> properties) {
		super();
		this.id = id;
		this.name = name;
		this.properties = properties;
	}
	
	
}
