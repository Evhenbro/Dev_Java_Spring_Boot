package ua.com.yarema.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.yarema.entity.OpenClose;
import ua.com.yarema.repository.OpenCloseRepository;
import ua.com.yarema.service.OpenCloseService;

@Service
public class OpenCloseServiceImpl extends CrudServiceImpl<OpenClose, Integer> implements OpenCloseService {

	@Autowired
	public OpenCloseServiceImpl(OpenCloseRepository repository) {
		super(repository);
	}

}
