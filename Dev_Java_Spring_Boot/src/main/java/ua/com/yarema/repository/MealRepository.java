package ua.com.yarema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.yarema.entity.Meal;

public interface MealRepository extends JpaRepository<Meal, Integer> {

}
