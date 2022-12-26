package com.smartgroup.socialbooks.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	@JsonInclude(value = Include.NON_NULL)
	private Date dateOfBirth;
	
	@JsonInclude(value = Include.NON_NULL)
	private String nacionality;
	
	@OneToMany(mappedBy = "author")
	@JsonIgnore
	private List<Book> book;
	
	public Author() {}

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

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getNacionality() {
		return nacionality;
	}

	public void setNacionality(String nacionality) {
		this.nacionality = nacionality;
	}

	public List<Book> getBook() {
		return book;
	}
	
}
