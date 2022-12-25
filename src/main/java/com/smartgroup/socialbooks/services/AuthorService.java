package com.smartgroup.socialbooks.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smartgroup.socialbooks.domain.Author;
import com.smartgroup.socialbooks.repository.AuthorRepository;

@Service
public class AuthorService {

	@Autowired
	private AuthorRepository authorRepository;
	
	@Transactional(readOnly = true)
	public List<Author> findAll() {
		return authorRepository.findAll();
	}
	
}
