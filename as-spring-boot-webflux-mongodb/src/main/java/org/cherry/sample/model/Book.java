package org.cherry.sample.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "books")
public class Book {

	@Id
	private String id;
    protected String isbn;
    protected String title;
    protected String author;
    protected String description;
    

    public Book() {}

    public Book(String id, String isbn, String title, String author, String description) {
  		this.id = id;
  		this.isbn = isbn;
  		this.title = title;
  		this.author = author;
  		this.description = description;
  	}
    
    public Book(Book source) {
    	this(source.id, source.isbn, source.title, source.author, source.description);
    }
    
    public Book apply(Book src) {
    	this.isbn = src.isbn;
    	this.title = src.title;
    	this.author = src.author;
    	this.description = src.description;
    	return this;
    }
    
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getIsbn() {
		return isbn;
	}
	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return author + " - " + title;
	}
    
}