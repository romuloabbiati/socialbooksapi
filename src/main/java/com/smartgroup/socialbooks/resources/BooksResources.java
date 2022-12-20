package com.smartgroup.socialbooks.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BooksResources {

	@RequestMapping(path = "/books", method = RequestMethod.GET)
	public String findAll() {
		return "Rest hands on, Git step-by-step";
	}
	
}
