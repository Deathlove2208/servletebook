package com.mycompany.model;


import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="categorys")
public class Category implements Serializable {
	@Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String catename;

	public Category() {
		
	}

	public Category(int id, String catename) {
		super();
		this.id = id;
		this.catename = catename;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCatename() {
		return catename;
	}

	public void setCatename(String catename) {
		this.catename = catename;
	}

}