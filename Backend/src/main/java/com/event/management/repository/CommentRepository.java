package com.event.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.event.management.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

}
