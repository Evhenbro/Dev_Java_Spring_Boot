package ua.com.yarema.validation.validator;

import java.time.LocalTime;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

import ua.com.yarema.entity.OpenClose;
import ua.com.yarema.repository.OpenCloseRepository;
import ua.com.yarema.validation.annotation.UniqueOpenClose;

@Component
public class OpenCloseValidator implements ConstraintValidator<UniqueOpenClose, String> {

	private final OpenCloseRepository openCloseRepository; 
	
	public OpenCloseValidator(OpenCloseRepository openCloseRepository) {
		this.openCloseRepository = openCloseRepository;
	}

	@Override
	public void initialize(UniqueOpenClose arg0) { }

	@Override
	public boolean isValid(String arg0, ConstraintValidatorContext arg1) {
		if (arg0.matches("^[0-9]:[0-5][0-9]$")) arg0 = "0"+arg0;
		if (!arg0.trim().isEmpty()) {
			OpenClose time = openCloseRepository.findByTime(LocalTime.parse(arg0));
			if (time!=null) {
				return false;
			} else return true;
			
		} else return true;
	}
}
