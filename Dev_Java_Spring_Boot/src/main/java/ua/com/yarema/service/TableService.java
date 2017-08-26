package ua.com.yarema.service;

import java.util.List;

import ua.com.yarema.entity.Table;

public interface TableService extends CrudService<Table, Integer> {
	
	List<String> findAllCafes();
}
