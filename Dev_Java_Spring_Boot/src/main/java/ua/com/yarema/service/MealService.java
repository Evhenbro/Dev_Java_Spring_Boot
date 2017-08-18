package ua.com.yarema.service;

import java.util.List;

import ua.com.yarema.entity.Meal;
import ua.com.yarema.model.view.MealView;

public interface MealService {
	
	List<String> findAllCuisines();
	
	List<String> findAllIngredients();
	
	List<String> findAllCafes();
	
	List<MealView> findAllViews();
	
	void save(Meal meal);
	
	void delete(Integer id);

}
