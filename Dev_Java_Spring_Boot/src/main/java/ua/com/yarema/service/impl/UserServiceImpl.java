package ua.com.yarema.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.yarema.entity.User;
import ua.com.yarema.repository.UserRepository;
import ua.com.yarema.service.UserService;

@Service
public class UserServiceImpl extends CrudServiceImpl<User, Integer> implements UserService {

	@Autowired
	public UserServiceImpl(UserRepository repository) {
		super(repository);
	}

}
