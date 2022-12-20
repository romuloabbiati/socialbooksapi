package com.smartgroup.socialbooks.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.smartgroup.socialbooks.domain.Book;
import com.smartgroup.socialbooks.repository.BookRepository;

@RestController
public class BookResource {
	
	@Autowired
	private BookRepository bookRepository;

	@RequestMapping(path = "/books", method = RequestMethod.GET)
	public List<Book> findAll() {
		return bookRepository.findAll();
	}
	
}
