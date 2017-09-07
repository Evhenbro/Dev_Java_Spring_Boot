package ua.com.yarema.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ua.com.yarema.entity.Cuisine;
import ua.com.yarema.repository.CuisineRepository;

@Component
public class CuisineConverter implements Converter<String, Cuisine> {

	private final CuisineRepository cuisineRepository; 
	
	public CuisineConverter(CuisineRepository cuisineRepository) {
		this.cuisineRepository = cuisineRepository;
	}

	@Override
	public Cuisine convert(String source) {
		return cuisineRepository.findByName(source);
	}

}
