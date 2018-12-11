package iamus.net.components.generated.Template;

import java.util.ArrayList;
import java.util.List;

import iamus.net.components.property.Property;
import iamus.net.components.component.Component;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Template {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	  private String componentTemplate;
	  private String controllerTemplate;
	  private String repositoryTemplate;
	  private String serviceTemplate;

	  public int getId() {
     return id;
  }
	  public void setId() {
   this.id = id;
 }
	  public String getComponentTemplate()  {
     returncomponentTemplate;
  }
	  public void setComponentTemplate()  {
   this.componentTemplate = componentTemplate;
 }

	  public String getControllerTemplate()  {
     returncontrollerTemplate;
  }
	  public void setControllerTemplate()  {
   this.controllerTemplate = controllerTemplate;
 }

	  public String getRepositoryTemplate()  {
     returnrepositoryTemplate;
  }
	  public void setRepositoryTemplate()  {
   this.repositoryTemplate = repositoryTemplate;
 }

	  public String getServiceTemplate()  {
     returnserviceTemplate;
  }
	  public void setServiceTemplate()  {
   this.serviceTemplate = serviceTemplate;
 }
	public Template {
		
	}
	
	  public Template( int id,  String componentTemplate, String controllerTemplate, String repositoryTemplate, String serviceTemplate)  {
		super();
		this.id = id;
		this.componentTemplate = componentTemplate;
		this.controllerTemplate = controllerTemplate;
		this.repositoryTemplate = repositoryTemplate;
		this.serviceTemplate = serviceTemplate;
		}
}