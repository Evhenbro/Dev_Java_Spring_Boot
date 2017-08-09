package ua.com.yarema.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.yarema.entity.Cafe;
import ua.com.yarema.repository.CafeRepository;
import ua.com.yarema.service.CafeService;

@Service
public class CafeServiceImpl extends CrudServiceImpl<Cafe, Integer>  implements CafeService {

	@Autowired
	public CafeServiceImpl(CafeRepository repository) {
		super(repository);
	}
}
