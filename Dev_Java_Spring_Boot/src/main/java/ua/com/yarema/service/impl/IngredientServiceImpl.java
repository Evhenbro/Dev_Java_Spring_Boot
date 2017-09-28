package ua.com.yarema.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ua.com.yarema.entity.Ingredient;
import ua.com.yarema.repository.IngredientRepository;
import ua.com.yarema.service.IngredientService;

@Service
public class IngredientServiceImpl extends CrudServiceImpl<Ingredient, Integer> implements IngredientService {
	
	private final IngredientRepository ingredientRepository;
	
	@Autowired
	public IngredientServiceImpl(IngredientRepository ingredientRepository) {
		super(ingredientRepository);
		this.ingredientRepository = ingredientRepository;
	}

	@Override
	public Page<Ingredient> findAll(Pageable pageable) {
		return ingredientRepository.findAll(pageable);
	}

}
