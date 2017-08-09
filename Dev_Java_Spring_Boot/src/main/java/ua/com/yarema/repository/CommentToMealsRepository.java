package ua.com.yarema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.yarema.entity.CommentToMeals;

public interface CommentToMealsRepository extends JpaRepository<CommentToMeals, Integer> {

}
