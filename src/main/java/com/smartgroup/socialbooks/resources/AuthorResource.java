package com.smartgroup.socialbooks.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartgroup.socialbooks.domain.Author;
import com.smartgroup.socialbooks.services.AuthorService;

@RestController
@RequestMapping(path = "/authors")
public class AuthorResource {

	@Autowired
	private AuthorService authorService;
	
	@RequestMapping
	public ResponseEntity<List<Author>> findAll() {
		List<Author> authors = authorService.findAll();
		return ResponseEntity.ok(authors);
	}
	
}
