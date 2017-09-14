package ua.com.yarema.converter;

import java.time.LocalTime;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ua.com.yarema.entity.OpenClose;
import ua.com.yarema.repository.OpenCloseRepository;

@Component
public class LocalTimeToOpenCloseConverter implements Converter<LocalTime, OpenClose> {

	private final OpenCloseRepository openCloseRepository;
	
	public LocalTimeToOpenCloseConverter(OpenCloseRepository openCloseRepository) {
		this.openCloseRepository = openCloseRepository;
	}

	@Override
	public OpenClose convert(LocalTime time) {
		return openCloseRepository.findByTime(time);
	}

}
