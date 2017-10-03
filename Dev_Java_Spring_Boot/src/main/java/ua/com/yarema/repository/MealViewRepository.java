package ua.com.yarema.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.com.yarema.model.filter.MealFilter;
import ua.com.yarema.model.view.MealView;

public interface MealViewRepository {

	Page<MealView> findAll(MealFilter mealFilter, Pageable pageable);
}
