package ua.com.yarema.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import ua.com.yarema.entity.User;
import ua.com.yarema.repository.UserRepository;

@Component
public class StringToUserConverter implements Converter<String, User> {

	private final UserRepository userRepository;
	
	public StringToUserConverter(UserRepository userRepository) {
		this.userRepository = userRepository;
	}


	@Override
	public User convert(String arg0) {
		if(!SecurityContextHolder.getContext().getAuthentication().getName().equals("anonymousUser")) {
			String login = SecurityContextHolder.getContext().getAuthentication().getName();
			userRepository.findByLogin(login);
		}
		return null;
	}

}
