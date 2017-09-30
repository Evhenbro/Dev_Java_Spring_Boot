package ua.com.yarema.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.com.yarema.entity.Meal;
import ua.com.yarema.model.filter.SimpleFilter;
import ua.com.yarema.model.request.MealRequest;
import ua.com.yarema.model.view.MealView;
import ua.com.yarema.repository.MealRepository;
import ua.com.yarema.service.MealService;

@Service
public class MealServiceImpl implements MealService {

	private final MealRepository mealRepository;

	public MealServiceImpl(MealRepository mealRepository) {
		this.mealRepository = mealRepository;
	}

	@Override
	public List<String> findAllCuisines() {
		return mealRepository.findAllCuisines();
	}

	@Override
	public List<String> findAllIngredients() {
		return mealRepository.findAllIngredients();
	}

	@Override
	public List<String> findAllCafes() {
		return mealRepository.findAllCafes();
	}

	@Override
	@Transactional(readOnly=true)
	public List<MealView> findAllViews() {
		List<MealView> views = mealRepository.findAllViews();
		views.forEach(this::loadIngredients);
		return views;
	}

	private void loadIngredients(MealView view) {
		view.setIngredients(mealRepository.finfAllIngredientsByMealId(view.getId()));
	}

	@Override
	public void delete(Integer id) {
		mealRepository.delete(id);
	}

	@Override
	public void save(MealRequest mealRequest) {
		Meal meal = new Meal();
		meal.setCafe(mealRequest.getCafe());
		meal.setCuisine(mealRequest.getCuisine());
		meal.setDescription(mealRequest.getDescription());
		meal.setVersion(mealRequest.getVersion());
		meal.setId(mealRequest.getId());
		meal.setIngredients(mealRequest.getIngredients());
		meal.setPhotoUrl(mealRequest.getPhotoUrl());
		meal.setPrice(new BigDecimal(mealRequest.getPrice()));
		meal.setTitle(mealRequest.getTitle());
		meal.setWeight(Integer.valueOf(mealRequest.getWeight()));
		mealRepository.save(meal);
	}

	@Override
	public MealRequest findOne(Integer id) {
		Meal meal = mealRepository.findOneRequest(id);
		MealRequest mealRequest = new MealRequest();
		mealRequest.setCafe(meal.getCafe());
		mealRequest.setCuisine(meal.getCuisine());
		mealRequest.setDescription(meal.getDescription());
		mealRequest.setVersion(meal.getVersion());
		mealRequest.setId(meal.getId());
		mealRequest.setIngredients(meal.getIngredients());
		mealRequest.setPhotoUrl(meal.getPhotoUrl());
		mealRequest.setPrice(String.valueOf(meal.getPrice()));
		mealRequest.setTitle(meal.getTitle());
		mealRequest.setWeight(String.valueOf(meal.getWeight()));
		return mealRequest;
	}

	@Override
	public MealView findMealViewById(Integer id) {
		MealView mealView = mealRepository.findMealViewById(id);
		return mealView;
	}

	@Override
	public List<MealView> findAllOwnMealsByUserLogin(String login) {
		List<MealView> views = mealRepository.findAllOwnMealsByUserLogin(login);
		views.forEach(this::loadIngredients);
		return views;
	}

	@Override
	public Page<MealView> findAllViews(Pageable pageable) {
		Page<MealView> mealViews = mealRepository.findAllViews(pageable);
		mealViews.forEach(this::loadIngredients);
		return mealViews;
	}

	@Override
	public Page<MealView> findAllOwnMealsByUserLogin(String name, Pageable pageable) {
		Page<MealView> mealViews = mealRepository.findAllOwnMealsByUserLogin(name, pageable);
		mealViews.forEach(this::loadIngredients);
		return mealViews;
	}
	
	@Override
	public Page<MealView> findAllViews(Pageable pageable, SimpleFilter simpleFilter) {
		return mealRepository.findAll(filter(simpleFilter), pageable);
	}
	
	public Specification<MealView> filter(SimpleFilter simpleFilter) {
		return (root, query, cb) -> {
			if (simpleFilter.getSearch().isEmpty()) return null;
			return cb.like(root.get("title"), simpleFilter.getSearch() + "%");
		};
	}
	
}
