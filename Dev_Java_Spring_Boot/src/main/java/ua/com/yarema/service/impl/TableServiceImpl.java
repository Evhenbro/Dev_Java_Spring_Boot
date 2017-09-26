package ua.com.yarema.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.yarema.entity.Cafe;
import ua.com.yarema.entity.Table;
import ua.com.yarema.model.request.TableRequest;
import ua.com.yarema.model.view.TableView;
import ua.com.yarema.repository.TableRepository;
import ua.com.yarema.service.TableService;

@Service
public class TableServiceImpl implements TableService {
	
	@Autowired
	private TableRepository tableRepository;
	
	@Autowired
	public TableServiceImpl(TableRepository tableRepository) {
		this.tableRepository = tableRepository;
	}

	@Override
	public void save(TableRequest tableRequest) {
		Table table = new Table();
		table.setNumber(tableRequest.getNumber());
		table.setCafe(tableRequest.getCafe());
		table.setCountOfPeople(Integer.valueOf(tableRequest.getCountOfPeople()));
		table.setId(tableRequest.getId());
		System.out.println(tableRequest.getId());
		table.setIsFree(Boolean.valueOf(tableRequest.getIsFree()));
		tableRepository.save(table);
	}

	@Override
	public void delete(Integer id) {
		tableRepository.delete(id);
	}

	@Override
	public TableRequest findOne(Integer id) {
		Table table = tableRepository.findOneRequest(id);
		TableRequest tableRequest = new TableRequest();
		tableRequest.setNumber(table.getNumber());
		tableRequest.setCafe(table.getCafe());
		tableRequest.setCountOfPeople(Integer.valueOf(table.getCountOfPeople()));
		tableRequest.setId(table.getId());
		System.out.println(table.getId());
		tableRequest.setIsFree(Boolean.valueOf(table.getIsFree()));
		return tableRequest;
	}

	@Override
	public List<TableView> findAllTableViewByCafeId(Integer id) {
		return tableRepository.findAllTableViewByCafeId(id);
	}

	@Override
	public Cafe findOneCafeById(Integer id) {
		return tableRepository.findOneCafeById(id);
	}

	@Override
	public void saveReservation(TableRequest request, Integer idTable) {
		Table table = new Table();
		table.setId(request.getId());
		table.setNumber(request.getNumber());
		table.setCountOfPeople(request.getCountOfPeople());
		table.setIsFree(Boolean.FALSE);
		table.setCafe(request.getCafe());
		table.setUser(request.getUser());
		table.setUserPhone(request.getUserPhone());
		tableRepository.save(table);
	}

	@Override
	public void dereserveTable(Integer idTable) {
		Table table = tableRepository.findOne(idTable);
		table.setIsFree(Boolean.TRUE);
		table.setUser(null);
		table.setUserPhone(null);
		tableRepository.save(table);
	}

	
}
