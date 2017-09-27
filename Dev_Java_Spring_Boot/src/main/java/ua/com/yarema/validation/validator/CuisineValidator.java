package ua.com.yarema.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

import ua.com.yarema.repository.CuisineRepository;
import ua.com.yarema.validation.annotation.UniqueCuisine;

@Component
public class CuisineValidator implements ConstraintValidator<UniqueCuisine, String> {

	private final CuisineRepository cuisineRepository;
	
	public CuisineValidator(CuisineRepository cuisineRepository) {
		this.cuisineRepository = cuisineRepository;
	}

	@Override
	public void initialize(UniqueCuisine arg0) { }

	@Override
	public boolean isValid(String arg0, ConstraintValidatorContext arg1) {
		return !cuisineRepository.existsByName(arg0);
	}
}
