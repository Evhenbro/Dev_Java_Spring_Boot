package ua.com.yarema.service;

import java.util.List;

import ua.com.yarema.model.view.CommentView;

public interface CommentService {

	List<CommentView> findAllCommentByCafeId(Integer id);
	
	List<CommentView> findAllCommentByMealId(Integer id);

}
