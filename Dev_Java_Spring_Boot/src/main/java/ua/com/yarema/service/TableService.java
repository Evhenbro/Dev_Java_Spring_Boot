package ua.com.yarema.service;

import java.util.List;

import ua.com.yarema.entity.Cafe;
import ua.com.yarema.model.request.TableRequest;
import ua.com.yarema.model.view.TableView;

public interface TableService {
	
	List<TableView> findAllTableViewByCafeId(Integer id);

	void save(TableRequest tableRequest);

	void delete(Integer id);

	TableRequest findOne(Integer id);
	
	Cafe findOneCafeById(Integer id);

	void saveReservation(TableRequest tableRequest, Integer idTable);

	void dereserveTable(Integer idTable);
}