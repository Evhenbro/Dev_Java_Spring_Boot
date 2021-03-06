package ua.com.yarema.service.impl;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.com.yarema.entity.Comment;
import ua.com.yarema.model.request.CommentRequest;
import ua.com.yarema.model.view.CommentView;
import ua.com.yarema.repository.CafeRepository;
import ua.com.yarema.repository.CommentRepository;
import ua.com.yarema.repository.MealRepository;
import ua.com.yarema.service.CommentService;


@Service
public class CommentServiceImpl implements CommentService {
	
	private final CommentRepository commentRepository;
	
	private final CafeRepository cafeRepository;
	
	private final MealRepository mealRepository;

	@Autowired
	public CommentServiceImpl(CommentRepository commentRepository, CafeRepository cafeRepository, MealRepository mealRepository) {
		this.commentRepository = commentRepository;
		this.cafeRepository = cafeRepository;
		this.mealRepository = mealRepository;
	}
	
	@Override
	public List<CommentView> findAllCommentByCafeId(Integer id) {
		return commentRepository.findAllCommentByCafeId(id);
	}

	@Override
	public List<CommentView> findAllCommentByMealId(Integer id) {
		return commentRepository.findAllCommentByMealId(id);
	}

	@Override
	public void saveCommentToCafe(CommentRequest commentRequest, Integer id) {
		Comment comment = new Comment();
		comment.setRate(commentRequest.getRate()=="" ? new BigDecimal(0.0) : new BigDecimal(commentRequest.getRate()));
		comment.setMessage(commentRequest.getMessage());
		comment.setUser(commentRequest.getUser());
		comment.setTime(LocalDateTime.now());
		comment.setCafe(cafeRepository.findOneRequest(id));
		commentRepository.save(comment);
	}

	@Override
	public void saveCommentToMeal(CommentRequest commentRequest, Integer id) {
		Comment comment = new Comment();
		comment.setMessage(commentRequest.getMessage());
		comment.setUser(commentRequest.getUser());
		comment.setTime(LocalDateTime.now());
		comment.setMeal(mealRepository.findOneRequest(id));
		commentRepository.save(comment);
	}
	
	@Override
	public void saveCommentToCommentCafe(CommentRequest commentRequest, Integer idComment) {
		Comment comment = new Comment();
		comment.setParentComment(commentRepository.findOneRequest(idComment)); 
		comment.setMessage(commentRequest.getMessage());
		comment.setUser(commentRequest.getUser());
		comment.setTime(LocalDateTime.now());
		commentRepository.save(comment);
	}

	@Override
	public void saveCommentToCommentMeal(CommentRequest commentRequest, Integer idComment) {
		Comment comment = new Comment();
		comment.setParentComment(commentRepository.findOneRequest(idComment)); 
		comment.setMessage(commentRequest.getMessage());
		comment.setUser(commentRequest.getUser());
		comment.setTime(LocalDateTime.now());
		commentRepository.save(comment);
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<CommentView> findAllToCafe(Integer id) {
		List<CommentView> list = findAllCommentByCafeId(id);
		loadChildComments(list);
		return list;
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<CommentView> findAllToMeal(Integer id) {
		List<CommentView> list = findAllCommentByMealId(id);
		loadChildComments(list);
		return list;
	}
	
	private void loadChildComments(List<CommentView> commentViews) {
		for (CommentView commentView : commentViews) {
			List<CommentView> commentViews2 = commentRepository.findAllCommentsByParent(commentView.getId());
			loadChildComments(commentViews2);
			commentView.setChildComment(commentViews2); 
		}	
	}

}
