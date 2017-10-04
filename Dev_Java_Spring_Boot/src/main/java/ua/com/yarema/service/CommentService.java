package ua.com.yarema.service;

import java.util.List;

import ua.com.yarema.entity.Comment;
import ua.com.yarema.model.request.CommentRequest;
import ua.com.yarema.model.view.CommentView;

public interface CommentService {
	
	List<Comment> findAll();
	
	List<Comment> findByCafeIdAndParent(Integer id, String )

	List<CommentView> findAllCommentByCafeId(Integer id);
	
	List<CommentView> findAllCommentByMealId(Integer id);

	void saveCommentToCafe(CommentRequest commentRequest, Integer id);

	void saveCommentToMeal(CommentRequest commentRequest, Integer id);
}
