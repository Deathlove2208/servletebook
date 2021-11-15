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
	private String img;
	private int views;
        private String author;
        private String detail;

	public Book() {
		
	}
	public Book(int id, String title, String img, int views, String author, String detail) {
		super();
		this.id = id;
		this.title = title;
		this.img = img;
		this.views = views;
                this.author = author;
                this.detail = detail;
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

	public int getViews() {
		return views;
	}


	public void setViews(int views) {
		this.views = views;
	}
        
        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }
	
        public void setImg(String img) {
            this.img = img;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }

        public String getImg() {
            return img;
        }

        public String getDetail() {
            return detail;
        }
}