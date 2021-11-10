package com.event.management.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.event.management.dao.CommentDao;
import com.event.management.repository.CommentRepository;

@Service
public class CommentDaoImpl implements CommentDao {

	@Autowired
	private CommentRepository repository;
}
