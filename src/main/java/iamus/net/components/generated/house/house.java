package iamus.net.components.generated.house;

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
public class House {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	  private String brand;
	  private String name;

	  public int getId() {
     return id;
  }
	  public void setId() {
   this.id = id;
 }
	  public String getBrand()  {
     returnbrand;
  }
	  public void setBrand()  {
   this.brand = brand;
 }

	  public String getName()  {
     returnname;
  }
	  public void setName()  {
   this.name = name;
 }
	public House {
		
	}
	
	  public House( int id,  String brand, String name)  {
		super();
		this.id = id;
		this.brand = brand;
		this.name = name;
		}
}