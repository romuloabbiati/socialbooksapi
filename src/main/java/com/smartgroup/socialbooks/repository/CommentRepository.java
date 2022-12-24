package com.smartgroup.socialbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smartgroup.socialbooks.domain.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>{

}
