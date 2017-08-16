package ua.com.yarema.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.yarema.entity.Comment;
import ua.com.yarema.repository.CommentRepository;
import ua.com.yarema.service.CommentService;


@Service
public class CommentServiceImpl extends CrudServiceImpl<Comment, Integer> implements CommentService {
	
	@Autowired
	public CommentServiceImpl(CommentRepository repository) {
		super(repository);
	}

}
