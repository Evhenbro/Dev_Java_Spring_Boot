package ua.com.yarema.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ua.com.yarema.entity.Cafe;
import ua.com.yarema.repository.CafeRepository;

@Component
public class CafeConverterStringToCafe implements Converter<Cafe, String> {

	private final CafeRepository cafeRepository;
	
	public CafeConverterStringToCafe(CafeRepository cafeRepository) {
		this.cafeRepository = cafeRepository;
	}

	@Override
	public String convert(Cafe arg0) {
		return arg0.getName();
	}

}
