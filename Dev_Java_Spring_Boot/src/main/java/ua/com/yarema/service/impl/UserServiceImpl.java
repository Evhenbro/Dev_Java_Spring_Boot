package ua.com.yarema.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ua.com.yarema.entity.Role;
import ua.com.yarema.entity.User;
import ua.com.yarema.model.request.RegistrationRequest;
import ua.com.yarema.repository.UserRepository;
import ua.com.yarema.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	private final UserRepository userRepository;

	private final PasswordEncoder passwordEncoder;
	

	public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}


	@Override
	public void save(RegistrationRequest registrationRequest) {
		User user = new User();
		user.setLogin(registrationRequest.getLogin());
		user.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));
		user.setRole(Role.ROLE_CAFE);
		userRepository.save(user);
	}

}
