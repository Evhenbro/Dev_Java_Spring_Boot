package ua.com.yarema.service;

import java.util.List;

import ua.com.yarema.entity.Cafe;
import ua.com.yarema.entity.Table;
import ua.com.yarema.model.request.TableRequest;

public interface TableService {
	
	List<Cafe> findAllCafes();

	List<Table> findAll();

	void save(TableRequest tableRequest);

	void delete(Integer id);

	TableRequest findOne(Integer id);
}