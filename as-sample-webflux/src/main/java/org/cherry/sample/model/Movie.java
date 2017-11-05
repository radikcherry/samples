package org.cherry.sample.model;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Movie {

	@Id
	private String id;
	private String name;
	private String director;
	private Integer year;
    

    public Movie() {}

    
	public Movie(String id, String name, String director, Integer year) {
		this.id = id;
		this.name = name;
		this.director = director;
		this.year = year;
	}

    
    public Movie(Movie src) {
    	this(src.id, src.name, src.director, src.year);
    }
    
    public Movie apply(Movie src) {
    	this.id = src.id;
    	this.name = src.name;
    	this.director = src.director;
    	this.year = src.year;
    	return this;
    }
    
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDirector() {
		return director;
	}


	public void setDirector(String director) {
		this.director = director;
	}


	public Integer getYear() {
		return year;
	}


	public void setYear(Integer year) {
		this.year = year;
	}

}