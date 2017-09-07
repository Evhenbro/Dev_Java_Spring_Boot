package ua.com.yarema.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ua.com.yarema.entity.Cafe;
import ua.com.yarema.repository.CafeRepository;

@Component
public class CafeConverter implements Converter<String, Cafe> {
	
	private final CafeRepository cafeRepository;
	
	public CafeConverter(CafeRepository cafeRepository) {
		this.cafeRepository = cafeRepository;
	}

	@Override
	public Cafe convert(String source) {
		return cafeRepository.findByName(source);
	}

}
