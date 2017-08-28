package ua.com.yarema.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.yarema.entity.Cafe;
import ua.com.yarema.entity.Table;
import ua.com.yarema.repository.TableRepository;
import ua.com.yarema.service.TableService;

@Service
public class TableServiceImpl extends CrudServiceImpl<Table, Integer> implements TableService {
	
	@Autowired
	private TableRepository repository;
	
	@Autowired
	public TableServiceImpl(TableRepository repository) {
		super(repository); 
	}

	@Override
	public List<Cafe> findAllCafes() {
		return repository.findAllCafes();
	}


	
}
