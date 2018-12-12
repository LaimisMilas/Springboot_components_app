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
	String controllerTemplate;/* = "package iamus.net.components.generated."+component.getName()+";\r\n" + 
			"\r\n" + 
			"import java.util.ArrayList;\r\n" + 
			"import java.util.List;\r\n" + 
			"\r\n" + 
			"import iamus.net.components.property.Property;\r\n" + 
			"import iamus.net.components.component.Component;\r\n" + 
			"import javax.persistence.CascadeType;\r\n" + 
			"import javax.persistence.Entity;\r\n" + 
			"import javax.persistence.GeneratedValue;\r\n" + 
			"import javax.persistence.GenerationType;\r\n" + 
			"import javax.persistence.Id;\r\n" + 
			"import javax.persistence.ManyToMany;\r\n" + 
			"import javax.persistence.OneToMany;\r\n" + 
			"\r\n" + 
			"import com.fasterxml.jackson.annotation.JsonIgnore;\r\n" + 
			"\r\n" + 
			"\r\n" + 
			"@Entity\r\n" + 
			"public class "+Utils.nameToUpperCase(component.getName())+" {\r\n" + 
			"	\r\n" + 
			"	@Id\r\n" + 
			"	@GeneratedValue(strategy=GenerationType.IDENTITY)\r\n" + 
			"	private int id;\r\n"; */
	@Type(type="text")
	String repositoryTemplate; /*= "package iamus.net.components.generated."+component.getName()+";\r\n" + 
			"\r\n" + 
			"import java.util.List;\r\n" + 
			"import java.util.Optional;\r\n" + 
			"\r\n" + 
			"import org.springframework.data.jpa.repository.Query;\r\n" + 
			"import org.springframework.data.repository.CrudRepository;\r\n" + 
			"import org.springframework.data.repository.query.Param;\r\n" + 
			"import org.springframework.transaction.annotation.Transactional;\r\n" + 
			"\r\n" + 
			"import iamus.net.components.property.Property;\r\n" + 
			"import iamus.net.components.component.Component;\r\n" + 
			"\r\n" + 
			"\r\n" + 
			"\r\n" + 
			"public interface "+Utils.nameToUpperCase(component.getName())+"Repository extends CrudRepository <"+Utils.nameToUpperCase(component.getName())+", String> {\r\n" + 
			"\r\n" + 
			"	Optional<"+Utils.nameToUpperCase(component.getName())+"> findById(int id);\r\n" + 
			"	@Transactional\r\n" + 
			"	Optional<"+Utils.nameToUpperCase(component.getName())+"> deleteById(int id);\r\n" + 
			"\r\n" + 
			"	@Query(value = \"FROM "+Utils.nameToUpperCase(component.getName())+" c WHERE \\n\" +\r\n" + 
			"		    \"c.name LIKE %:searchTerm% \" )\r\n" + 
			"		    List<"+Utils.nameToUpperCase(component.getName())+"> findBySearchTermNative(@Param(\"searchTerm\") String searchTerm);\r\n" + 
			"}\r\n" + 
			"";*/
	@Type(type="text")
	String serviceTemplate;/* = "package iamus.net.components.generated."+component.getName()+";\r\n" + 
			"import java.util.ArrayList;\r\n" + 
			"import java.util.List;\r\n" + 
			"import java.util.Optional;\r\n" + 
			"\r\n" + 
			"import org.springframework.beans.factory.annotation.Autowired;\r\n" + 
			"import org.springframework.stereotype.Service;\r\n" + 
			"\r\n" + 
			"import iamus.net.components.property.Property;\r\n" + 
			"\r\n" + 
			"\r\n" + 
			"\r\n" + 
			"@Service\r\n" + 
			"public class "+Utils.nameToUpperCase(component.getName())+"Service {\r\n" + 
			"	\r\n" + 
			"	@Autowired\r\n" + 
			"	public "+Utils.nameToUpperCase(component.getName())+"Repository "+component.getName()+"Repository;\r\n" + 
			"	\r\n" + 
			"	public List <"+Utils.nameToUpperCase(component.getName())+"> getAll"+Utils.nameToUpperCase(component.getName())+"s() {\r\n" + 
			"		\r\n" + 
			"		List <"+Utils.nameToUpperCase(component.getName())+"> "+component.getName()+"s = new ArrayList<>();\r\n" + 
			"		 "+component.getName()+"Repository.findAll()\r\n" + 
			"		 .forEach("+component.getName()+"s::add);			\r\n" + 
			"		 return "+component.getName()+"s;\r\n" + 
			"	}\r\n" + 
			"	\r\n" + 
			"		public List<"+Utils.nameToUpperCase(component.getName())+"> get"+Utils.nameToUpperCase(component.getName())+"s(String id) {\r\n" + 
			"		\r\n" + 
			"		List <"+Utils.nameToUpperCase(component.getName())+"> "+component.getName()+"s = new ArrayList<>();\r\n" + 
			"		 "+component.getName()+"Repository.findBySearchTermNative(id)\r\n" + 
			"		.forEach("+component.getName()+"s::add);\r\n" + 
			"		return "+component.getName()+"s;\r\n" + 
			"	}\r\n" + 
			"	\r\n" + 
			"	\r\n" + 
			"	public Optional<"+Utils.nameToUpperCase(component.getName())+"> get"+Utils.nameToUpperCase(component.getName())+"(int id) {\r\n" + 
			"		return "+component.getName()+"Repository.findById(id);\r\n" + 
			"	}\r\n" + 
			"	\r\n" + 
			"\r\n" + 
			"	public void create"+Utils.nameToUpperCase(component.getName())+"("+Utils.nameToUpperCase(component.getName())+" "+component.getName()+") {\r\n" + 
			"		"+component.getName()+"Repository.save("+component.getName()+");\r\n" + 
			"	}\r\n" + 
			"\r\n" + 
			"	public void update"+Utils.nameToUpperCase(component.getName())+"("+Utils.nameToUpperCase(component.getName())+" "+component.getName()+", String id) {\r\n" + 
			"		"+component.getName()+"Repository.save("+component.getName()+"); \r\n" + 
			"		\r\n" + 
			"	}\r\n" + 
			"\r\n" + 
			"	public void delete"+Utils.nameToUpperCase(component.getName())+"(int id) {\r\n" + 
			"		\r\n" + 
			"		"+component.getName()+"Repository.deleteById(id);\r\n" + 
			"	}\r\n" + 
			"	\r\n" + 
			"}\r\n" + 
			"";*/
	
	
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
