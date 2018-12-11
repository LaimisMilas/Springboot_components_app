package iamus.net.components.component;

import java.util.ArrayList;
import java.util.List;

import iamus.net.components.generator.Template;
import iamus.net.components.property.Property;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Component {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;

	@ManyToMany(targetEntity=Property.class)
	private List<Property> properties = new ArrayList<>();
	
	
	
	public String propertiesToString() {
		String string = "";
		for(int i =0; i<properties.size(); i++) {
			string += "	  private " + properties.get(i).getType() +" " + properties.get(i).getName() + ";\r\n";
		}
		return string;
	}
	public String GettersSettersToString() {
		String string = "\r\n	  public int getId() {\r\n"+
						"     return id;\r\n"+
						"  }\r\n"+
						"	  public void setId() {\r\n"+
						"   this.id = id;\r\n"+
						" }";
		for(int i =0; i<properties.size(); i++) {
			string += "\r\n	  public " + properties.get(i).getType() +" get" + properties.get(i).getName().substring(0, 1).toUpperCase() + properties.get(i).getName().substring(1) + "()  {\r\n" +
						"     return" + properties.get(i).getName() + ";\r\n" + 
					"  }\r\n" +
					"	  public void set" + properties.get(i).getName().substring(0, 1).toUpperCase() + properties.get(i).getName().substring(1) + "()  {\r\n" +
					"   this."+ properties.get(i).getName() + " = " + properties.get(i).getName() + ";\r\n" +
					" }\r\n";
		}
		return string;
	}
	
	public String ConstructorToString() {
		String string = "	public "+this.getName().substring(0, 1).toUpperCase()+this.getName().substring(1)+" {\r\n" + 
				"		\r\n" + 
				"	}\r\n" + 
				"	\r\n" + 
				"";
				string += "	  public "+ this.getName().substring(0, 1).toUpperCase() + this.getName().substring(1) + "( int id, ";
		for(int i =0; i<properties.size(); i++) {
			string += " "+properties.get(i).getType() + " " + properties.get(i).getName();
			if(i!=properties.size()-1) {
			string	+= ",";
			}
		}
			string+= ")  {\r\n"+
		"		super();\r\n"+
		"		this.id = id;\r\n";
			for(int i =0; i<properties.size(); i++) {
				string +="		this."+properties.get(i).getName()+" = "+properties.get(i).getName()+";\r\n";
			}
			string += "		}\r\n"+
					  "}";
		return string;
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
	
	public Template getTemplate() {
		return template;
	}
	public void setTemplate(Template template) {
		this.template = template;
	}
			public List<Property> getProperties() {
					List<Property> newProperties = new ArrayList<>();
					 this.properties.forEach(val -> {
						 Property prop = new Property();
						 prop.setId(val.getId());
						 prop.setName(val.getName());
						 prop.setType(val.getType());
						 newProperties.add(prop);
					 });
					 
					 return newProperties;
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
