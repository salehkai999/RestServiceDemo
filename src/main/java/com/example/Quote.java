package com.example;

/*
	Saleh Qaseer 1981576
	Homework 4
*/

public class Quote {

    private long id;
	private String data;
	private String author;
		
	// constructor to intialize new quotes with all attributes
	public Quote(long id, String data, String author) {
		super();
		this.id = id;
		this.data = data;
		this.author = author;
	}

	public Quote() {
	
	}

	// a bunch of setters and getters
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}

	// overridding the toString method for testing purposes 
	@Override
	public String toString() {
		return "Quote [id=" + id + ", data=" + data + ", author=" + author + "]";
	}
	
    
}