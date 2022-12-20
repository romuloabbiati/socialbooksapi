package com.smartgroup.socialbooks.domain;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class Book {
	
	@JsonInclude(value = Include.NON_NULL)
	private Long id;
	
	@JsonInclude(value = Include.NON_NULL)
	private String name;
	
	@JsonInclude(value = Include.NON_NULL)
	private Date release;
	
	@JsonInclude(value = Include.NON_NULL)
	private String publisher;
	
	@JsonInclude(value = Include.NON_NULL)
	private String summary;
	
	@JsonInclude(value = Include.NON_NULL)
	private List<Comment> comments;
	
	@JsonInclude(value = Include.NON_NULL)
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
