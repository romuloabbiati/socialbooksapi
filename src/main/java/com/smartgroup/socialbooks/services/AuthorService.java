package com.smartgroup.socialbooks.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smartgroup.socialbooks.domain.Author;
import com.smartgroup.socialbooks.repository.AuthorRepository;
import com.smartgroup.socialbooks.services.exceptions.ResourceAlreadyExistsException;
import com.smartgroup.socialbooks.services.exceptions.ResourceNotFoundException;

@Service
public class AuthorService {

	@Autowired
	private AuthorRepository authorRepository;
	
	@Transactional(readOnly = true)
	public List<Author> findAll() {
		return authorRepository.findAll();
	}
	
	@Transactional(readOnly = true)
	public Author findById(Long id) {
		Optional<Author> authorOptional = authorRepository.findById(id);
		return authorOptional.orElseThrow(
				() -> new ResourceNotFoundException("Author not found!"));
	}
	
	@Transactional
	public Author save(Author author) {
		if(author.getId() != null) {
			Author retrievedAuthor = findById(author.getId());
			
			if(retrievedAuthor != null) {
				throw new ResourceAlreadyExistsException("This author already exists!");
			}
		}
		
		return authorRepository.save(author);
	}
	
}
