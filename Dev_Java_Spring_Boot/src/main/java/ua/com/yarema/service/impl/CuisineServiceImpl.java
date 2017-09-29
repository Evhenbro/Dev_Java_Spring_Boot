package ua.com.yarema.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import ua.com.yarema.entity.Cuisine;
import ua.com.yarema.model.filter.SimpleFilter;
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

	@Override
	public Page<Cuisine> findAll(Pageable pageable, SimpleFilter simpleFilter) {
		// TODO Auto-generated method stub
		return cuisineRepository.findAll(filter(simpleFilter), pageable);
	}

	private Specification<Cuisine> filter(SimpleFilter simpleFilter) {
		return (root, query, cb) -> {
			if (simpleFilter.getSearch().isEmpty()) return null;
			return cb.like(root.get("name"), simpleFilter.getSearch()+"%");
		};
	}
}
