package ua.com.yarema.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ua.com.yarema.entity.Comment;
import ua.com.yarema.model.view.CommentView;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
	
	@Query("SELECT new ua.com.yarema.model.view.CommentView(comment.message, comment.time, comment.rate, comment.user) FROM Comment comment JOIN comment.cafe cafe WHERE cafe.id=?1")
	List<CommentView> findAllCommentByCafeId(Integer id);
	
	@Query("SELECT new ua.com.yarema.model.view.CommentView(comment.message, comment.time, comment.rate, comment.user) FROM Comment comment JOIN comment.meal meal WHERE meal.id=?1")
	List<CommentView> findAllCommentByMealId(Integer id);

}
