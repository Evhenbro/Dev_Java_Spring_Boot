package ua.com.yarema.converter;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringConverterToLocalTime implements Converter<String, LocalTime> {
	
	@Override
	public LocalTime convert(String arg0) {
		LocalTime time = LocalTime.parse(arg0, DateTimeFormatter.ISO_LOCAL_TIME);
		return time;
	}
	
}
