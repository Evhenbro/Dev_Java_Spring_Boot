package ua.com.yarema.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.yarema.entity.Ingredient;
import ua.com.yarema.repository.IngredientRepository;
import ua.com.yarema.service.IngredientService;

@Service
public class IngredientServiceImpl extends CrudServiceImpl<Ingredient, Integer> implements IngredientService {

	@Autowired
	public IngredientServiceImpl(IngredientRepository repository) {
		super(repository);
	}

}
