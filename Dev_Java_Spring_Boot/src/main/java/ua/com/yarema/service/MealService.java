package ua.com.yarema.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.com.yarema.model.filter.SimpleFilter;
import ua.com.yarema.model.request.MealRequest;
import ua.com.yarema.model.view.MealView;

public interface MealService {
	
	List<String> findAllCuisines();
	
	List<String> findAllIngredients();
	
	List<String> findAllCafes();
	
	List<MealView> findAllViews();
	
	void save(MealRequest mealRequest);
	
	void delete(Integer id);

	MealRequest findOne(Integer id);

	MealView findMealViewById(Integer id);

	List<MealView> findAllOwnMealsByUserLogin(String login);

	Page<MealView> findAllViews(Pageable pageable);

	Page<MealView> findAllOwnMealsByUserLogin(String name, Pageable pageable);

	Page<MealView> findAllViews(Pageable pageable, SimpleFilter simpleFilter);

}
