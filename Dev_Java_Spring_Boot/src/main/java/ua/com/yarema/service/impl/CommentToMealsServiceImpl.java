package ua.com.yarema.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.yarema.entity.CommentToMeals;
import ua.com.yarema.repository.CommentToMealsRepository;
import ua.com.yarema.service.CommentToMealsService;

@Service
public class CommentToMealsServiceImpl extends CrudServiceImpl<CommentToMeals, Integer> implements CommentToMealsService {

	@Autowired
	public CommentToMealsServiceImpl(CommentToMealsRepository repository) {
		super(repository);
	}

}
