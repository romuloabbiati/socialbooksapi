package com.smartgroup.socialbooks.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.smartgroup.socialbooks.domain.Book;

@RestController
public class BooksResources {

	@RequestMapping(path = "/books", method = RequestMethod.GET)
	public List<Book> findAll() {
		Book b1 = new Book("REST Hands On");
		Book b2 = new Book("Git step-by-step");
		Book[] books = { b1, b2 };
		return Arrays.asList(books);
	}
	
}
