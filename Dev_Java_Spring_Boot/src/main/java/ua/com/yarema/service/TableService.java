package ua.com.yarema.service;

import java.util.List;

import ua.com.yarema.entity.Cafe;
import ua.com.yarema.model.request.TableRequest;
import ua.com.yarema.model.view.TableView;

public interface TableService {
	
	List<Cafe> findAllCafes();

	List<TableView> findAllTableViewByCafeId(Integer id);

	void save(TableRequest tableRequest);

	void delete(Integer id);

	TableRequest findOne(Integer id);
}