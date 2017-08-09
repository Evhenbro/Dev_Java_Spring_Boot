package ua.com.yarema.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.yarema.entity.Meal;
import ua.com.yarema.repository.MealRepository;
import ua.com.yarema.service.MealService;

@Service
public class MealServiceImpl extends CrudServiceImpl<Meal, Integer> implements MealService {

	@Autowired
	public MealServiceImpl(MealRepository repository) {
		super(repository);
	}

}
