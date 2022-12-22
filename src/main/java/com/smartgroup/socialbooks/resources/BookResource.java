package com.smartgroup.socialbooks.resources;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.smartgroup.socialbooks.domain.Book;
import com.smartgroup.socialbooks.repository.BookRepository;
import com.smartgroup.socialbooks.services.exceptions.ResourceNotFoundException;

@RestController
@RequestMapping(path = "/books")
public class BookResource {
	
	@Autowired
	private BookRepository bookRepository;

	@RequestMapping(method = RequestMethod.GET)
	public List<Book> findAll() {
		return bookRepository.findAll();
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public Book findById(@PathVariable Long id) {
		Optional<Book> bookOptional = bookRepository.findById(id);
		return bookOptional.orElseThrow(
				() -> new ResourceNotFoundException("Book with id " + id + " not found!"));
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> save(@RequestBody Book book) {
		book = bookRepository.save(book);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(book.getId()).toUri();

		
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		bookRepository.deleteById(id);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public void update(@PathVariable Long id, @RequestBody Book book) {
		book.setId(id);
		bookRepository.save(book);
	}
	
}
