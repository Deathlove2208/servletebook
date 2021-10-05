package com.mycompany.model;


import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="books")
public class Book implements Serializable {
	@Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private String link;
	private String thumbnail;
	private int views;


	public Book() {
		
	}
	public Book(int id, String title, String link, String thumbnail, int views) {
		super();
		this.id = id;
		this.title = title;
		this.link = link;
		this.thumbnail = thumbnail;
		this.views = views;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getLink() {
		return link;
	}


	public void setLink(String link) {
		this.link = link;
	}


	public String getThumbnail() {
		return thumbnail;
	}


	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}


	public int getViews() {
		return views;
	}


	public void setViews(int views) {
		this.views = views;
	}
	
}