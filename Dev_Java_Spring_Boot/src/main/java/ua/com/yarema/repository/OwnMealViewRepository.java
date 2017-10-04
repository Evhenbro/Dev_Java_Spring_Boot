package ua.com.yarema.repository;

import java.security.Principal;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.com.yarema.model.filter.MealFilter;
import ua.com.yarema.model.view.MealView;

public interface OwnMealViewRepository {

	Page<MealView> findAll(MealFilter mealFilter, Pageable pageable, Principal principal);
	
}
