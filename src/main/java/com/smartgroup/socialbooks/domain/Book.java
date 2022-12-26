package com.smartgroup.socialbooks.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
public class Book {
	
	@JsonInclude(value = Include.NON_NULL)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonInclude(value = Include.NON_NULL)
	private String name;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	@JsonInclude(value = Include.NON_NULL)
	private Date release;
	
	@JsonInclude(value = Include.NON_NULL)
	private String publisher;
	
	@JsonInclude(value = Include.NON_NULL)
	private String summary;
	
	@JsonInclude(value = Include.NON_EMPTY)
	@OneToMany(mappedBy = "book")
	private List<Comment> comments;
	
	@ManyToOne
	@JoinColumn(name = "author_id")
	@JsonInclude(value = Include.NON_NULL)
	private Author author;
	
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

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

}
