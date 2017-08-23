package ua.com.yarema.service.impl;


import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.com.yarema.entity.Meal;
import ua.com.yarema.model.view.MealView;
import ua.com.yarema.repository.MealRepository;
import ua.com.yarema.service.MealService;

@Service
public class MealServiceImpl implements MealService {

	private final MealRepository repository;

	public MealServiceImpl(MealRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<String> findAllCuisines() {
		return repository.findAllCuisines();
	}

	@Override
	public List<String> findAllIngredients() {
		return repository.findAllIngredients();
	}

	@Override
	public List<String> findAllCafes() {
		return repository.findAllCafes();
	}

	@Override
	@Transactional(readOnly=true)
	public List<MealView> findAllViews() {
		List<MealView> views = repository.findAllViews();
		views.forEach(this::loadIngredients);
		return views;
	}

	private void loadIngredients(MealView view) {
		view.setIngredients(repository.finfAllIngredientsByMealId(view.getId()));
	}
	
	@Override
	public void save(Meal meal) {
		repository.save(meal);
	}

	@Override
	public void delete(Integer id) {
		repository.delete(id);
	}

}
