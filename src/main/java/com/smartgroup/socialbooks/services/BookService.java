package com.smartgroup.socialbooks.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smartgroup.socialbooks.domain.Book;
import com.smartgroup.socialbooks.domain.Comment;
import com.smartgroup.socialbooks.repository.BookRepository;
import com.smartgroup.socialbooks.repository.CommentRepository;
import com.smartgroup.socialbooks.services.exceptions.ResourceNotFoundException;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private CommentRepository commentRepository;
	
	@Transactional(readOnly = true)
	public List<Book> findAll() {
		return bookRepository.findAll();
	}
	
	@Transactional(readOnly = true)
	public Book findById(Long id) {
		Optional<Book> bookOptional = bookRepository.findById(id);
		return bookOptional.orElseThrow(
				() -> new ResourceNotFoundException("Book with id " + id + " not found!"));
	}
	
	@Transactional
	public Book save(Book book) {
		book.setId(null);
		return bookRepository.save(book);
	}
	
	public void delete(Long id) {
		try {
			bookRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Book not found!");
		}
	}
	
	@Transactional
	public Book update(Book book) {
		verifyIfExists(book);
		return bookRepository.save(book);
	}
	
	@Transactional(readOnly = true)
	public List<Comment> findCommentByBook(Long id) {
		Book book = findById(id);
		
		return book.getComments();
	}
	
	@Transactional
	public void addComment(Long id, Comment comment) {
		
		Book book = findById(id);
		
		comment.setBook(book);
		comment.setDate(new Date());
		
		commentRepository.save(comment);
	}
	
	private void verifyIfExists(Book book) {
		findById(book.getId());
	}
	
}
