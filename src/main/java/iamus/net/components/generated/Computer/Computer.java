package iamus.net.components.generated.Computer;

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
public class Computer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	  private String GPU;
	  private String processor;
	  private String name;

	  public int getId() {
     return id;
  }
	  public void setId() {
   this.id = id;
 }
	  public String getGPU()  {
     returnGPU;
  }
	  public void setGPU()  {
   this.GPU = GPU;
 }

	  public String getProcessor()  {
     returnprocessor;
  }
	  public void setProcessor()  {
   this.processor = processor;
 }

	  public String getName()  {
     returnname;
  }
	  public void setName()  {
   this.name = name;
 }
	public Computer {
		
	}
	
	  public Computer( int id,  String GPU, String processor, String name)  {
		super();
		this.id = id;
		this.GPU = GPU;
		this.processor = processor;
		this.name = name;
		}
}