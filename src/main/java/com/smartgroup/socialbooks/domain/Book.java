package com.smartgroup.socialbooks.domain;

import java.util.Date;
import java.util.List;

public class Book {
	
	private Long id;
	private String name;
	private Date release;
	private String publisher;
	private String summary;
	private List<Comment> comments;
	private String author;
	
	public Book() {}
	
	public Book(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getRelease() {
		return release;
	}
	public void setRelease(Date release) {
		this.release = release;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}

}
