package org.cherry.sample.model;

public class Book {

	private String title;
	private String author;
	private String description;
	private String isbn;
	private int year;
	

	public Book(String title, String author, String description, String isbn, int year) {
		this.title = title;
		this.author = author;
		this.description = description;
		this.isbn = isbn;
		this.year = year;
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
	
	
	public int getYear() {
		return year;
	}
	
	
	public void setYear(int year) {
		this.year = year;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getIsbn() {
		return isbn;
	}


	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	
}
