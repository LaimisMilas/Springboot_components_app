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
	@Type(type="text")
	String text;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Template() {
		
	}

	public Template(int id, String text) {
		super();
		this.id = id;
		this.text = text;
	}
	
	
}
