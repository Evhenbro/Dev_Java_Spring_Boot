package ua.com.yarema.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ua.com.yarema.entity.Ingredient;
import ua.com.yarema.repository.IngredientRepository;

@Component
public class IngredientConverter implements Converter<String, Ingredient> {

	private final IngredientRepository ingredientRepository;
	
	
	public IngredientConverter(IngredientRepository ingredientRepository) {
		this.ingredientRepository = ingredientRepository;
	}

	@Override
	public Ingredient convert(String source) {
		return ingredientRepository.findByName(source);
	}

}
