package ua.com.yarema.converter;

import java.time.LocalTime;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ua.com.yarema.entity.OpenClose;
import ua.com.yarema.repository.OpenCloseRepository;

@Component
public class StringConverterToOpenClose implements Converter<String, OpenClose> {

	private final OpenCloseRepository openCloseRepository;
	
	public StringConverterToOpenClose(OpenCloseRepository openCloseRepository) {
		this.openCloseRepository = openCloseRepository;
	}

	@Override
	public OpenClose convert(String arg0) {
		return openCloseRepository.findByTime(LocalTime.parse(arg0));
	}

}
