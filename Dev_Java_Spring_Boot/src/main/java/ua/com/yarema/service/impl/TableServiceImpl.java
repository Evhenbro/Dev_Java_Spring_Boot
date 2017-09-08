package ua.com.yarema.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.yarema.entity.Cafe;
import ua.com.yarema.entity.Table;
import ua.com.yarema.model.request.TableRequest;
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
	public List<Cafe> findAllCafes() {
		return tableRepository.findAllCafes();
	}

	@Override
	public List<Table> findAll() {
		return tableRepository.findAll();
	}

	@Override
	public void save(TableRequest tableRequest) {
		Table table = new Table();
		table.setCafe(tableRequest.getCafe());
		table.setCountOfPeople(Integer.valueOf(tableRequest.getCountOfPeople()));
		table.setId(tableRequest.getId());
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
		tableRequest.setCafe(table.getCafe());
		tableRequest.setCountOfPeople(Integer.valueOf(table.getCountOfPeople()));
		tableRequest.setId(table.getId());
		tableRequest.setIsFree(Boolean.valueOf(table.getIsFree()));
		return tableRequest;
	}

	
}
