package ua.com.yarema.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.yarema.entity.CommentToCafes;
import ua.com.yarema.repository.CommentToCafesRepository;
import ua.com.yarema.service.CommentToCafesService;

@Service
public class CommentToCafesServiceImpl extends CrudServiceImpl<CommentToCafes, Integer> implements CommentToCafesService {
	
	@Autowired
	public CommentToCafesServiceImpl(CommentToCafesRepository repository) {
		super(repository);
	}

}
