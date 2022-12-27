package com.smartgroup.socialbooks.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.smartgroup.socialbooks.domain.Author;
import com.smartgroup.socialbooks.services.AuthorService;

@RestController
@RequestMapping(path = "/authors")
public class AuthorResource {

	@Autowired
	private AuthorService authorService;
	
	@RequestMapping(method = RequestMethod.GET, 
					produces = { MediaType.APPLICATION_JSON_VALUE, 
								 MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<Author>> findAll() {
		List<Author> authors = authorService.findAll();
		return ResponseEntity.ok(authors);
	}
	
	@RequestMapping(path = "/{id}" ,method = RequestMethod.GET)
	public ResponseEntity<Author> findById(@PathVariable Long id) {
		Author author = authorService.findById(id);
		return ResponseEntity.ok(author);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> save(@Valid @RequestBody Author author) {
		authorService.save(author);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(author.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
}
