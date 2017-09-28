package ua.com.yarema.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ua.com.yarema.entity.Cuisine;
import ua.com.yarema.repository.CuisineRepository;
import ua.com.yarema.service.CuisineService;

@Service
public class CuisineServiceImpl extends CrudServiceImpl<Cuisine, Integer> implements CuisineService {
	
	private final CuisineRepository cuisineRepository;
	
	@Autowired
	public CuisineServiceImpl(CuisineRepository cuisineRepository) {
		super(cuisineRepository);
		this.cuisineRepository = cuisineRepository;
	}

	@Override
	public Page<Cuisine> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return cuisineRepository.findAll(pageable);
	}

}
