package com.smartgroup.socialbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smartgroup.socialbooks.domain.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long>{

}
