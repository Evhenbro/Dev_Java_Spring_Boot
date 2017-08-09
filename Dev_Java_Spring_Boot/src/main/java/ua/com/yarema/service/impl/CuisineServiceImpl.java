package ua.com.yarema.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.yarema.entity.Cuisine;
import ua.com.yarema.repository.CuisineRepository;
import ua.com.yarema.service.CuisineService;

@Service
public class CuisineServiceImpl extends CrudServiceImpl<Cuisine, Integer> implements CuisineService {

	@Autowired
	public CuisineServiceImpl(CuisineRepository repository) {
		super(repository);
	}

}
