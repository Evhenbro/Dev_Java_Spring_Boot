package ua.com.yarema.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

import ua.com.yarema.repository.IngredientRepository;
import ua.com.yarema.validation.annotation.UniqueIngredient;

@Component
public class IngredientValidator implements ConstraintValidator<UniqueIngredient, String> {

	private IngredientRepository ingredientRepository;

	public IngredientValidator(IngredientRepository ingredientRepository) {
		this.ingredientRepository = ingredientRepository;
	}

	@Override
	public void initialize(UniqueIngredient arg0) { }

	@Override
	public boolean isValid(String arg0, ConstraintValidatorContext arg1) {
		return !ingredientRepository.existsByName(arg0);
	}
}
