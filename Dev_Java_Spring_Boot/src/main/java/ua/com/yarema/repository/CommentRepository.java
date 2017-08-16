package ua.com.yarema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.yarema.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

}
