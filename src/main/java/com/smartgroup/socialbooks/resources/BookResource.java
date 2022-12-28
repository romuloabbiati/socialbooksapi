package com.smartgroup.socialbooks.resources;

import java.net.URI;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.smartgroup.socialbooks.domain.Book;
import com.smartgroup.socialbooks.domain.Comment;
import com.smartgroup.socialbooks.services.BookService;

@RestController
@RequestMapping(path = "/books")
public class BookResource {
	
	@Autowired
	private BookService bookService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Book>> findAll() {
		List<Book> booksList = bookService.findAll();
		return ResponseEntity.ok(booksList);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Book> findById(@PathVariable Long id) {
		Book book = bookService.findById(id);
		
		CacheControl cacheControl = CacheControl.maxAge(20, TimeUnit.SECONDS);
		
		return ResponseEntity.status(HttpStatus.OK).cacheControl(cacheControl).body(book);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> save(@Valid @RequestBody Book book) {
		book = bookService.save(book);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(book.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		bookService.delete(id);
		
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody Book book) {
		book.setId(id);
		bookService.update(book);
		
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(path = "/{id}/comments", method = RequestMethod.GET)
	public ResponseEntity<List<Comment>> findCommentsByBook(@PathVariable Long id) {
		List<Comment> comments = bookService.findCommentByBook(id);
		
		return ResponseEntity.ok(comments);
	}
	
	@RequestMapping(path = "/{id}/comments", method = RequestMethod.POST)
	public ResponseEntity<Void> addComment(
			@PathVariable Long id, 
			@RequestBody Comment comment) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		comment.setUser(auth.getName());
		
		bookService.addComment(id, comment);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
}
