package ua.com.yarema.converter;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

@Component
public class LocalTimeToStringConverter implements org.springframework.core.convert.converter.Converter<LocalTime, String> {

	@Override
	public String convert(LocalTime time) {
		return time.format(DateTimeFormatter.ofPattern("HH:mm"));
	}

}
