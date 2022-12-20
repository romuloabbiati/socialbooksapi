package com.smartgroup.socialbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smartgroup.socialbooks.domain.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

}
