package ua.com.yarema.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.yarema.model.view.CommentView;
import ua.com.yarema.repository.CommentRepository;
import ua.com.yarema.service.CommentService;


@Service
public class CommentServiceImpl implements CommentService {
	
	private final CommentRepository commentRepository;

	@Autowired
	public CommentServiceImpl(CommentRepository commentRepository) {
		this.commentRepository = commentRepository;
	}
	
	@Override
	public List<CommentView> findAllCommentByCafeId(Integer id) {
		return commentRepository.findAllCommentByCafeId(id);
	}


	@Override
	public List<CommentView> findAllCommentByMealId(Integer id) {
		return commentRepository.findAllCommentByMealId(id);
	}
	
	
	

}
