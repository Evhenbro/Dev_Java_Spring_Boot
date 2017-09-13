package ua.com.yarema.service.impl;


import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.yarema.entity.OpenClose;
import ua.com.yarema.repository.OpenCloseRepository;
import ua.com.yarema.service.OpenCloseService;

@Service
public class OpenCloseServiceImpl implements OpenCloseService {

	private OpenCloseRepository openCloseRepository;  
	
	@Autowired
	public OpenCloseServiceImpl(OpenCloseRepository openCloseRepository) {
		this.openCloseRepository = openCloseRepository;
	}

	@Override
	public List<LocalTime> findAllTimes() {
		// TODO Auto-generated method stub
		return openCloseRepository.findAllTimes();
	}

	@Override
	public OpenClose findOne(Integer id) {
		// TODO Auto-generated method stub
		return openCloseRepository.findOne(id);
	}

	@Override
	public List<OpenClose> findAll() {
		// TODO Auto-generated method stub
		return openCloseRepository.findAll();
	}

	@Override
	public void save(OpenClose entity) {
		openCloseRepository.save(entity);
	}

	@Override
	public void delete(Integer id) {
		openCloseRepository.delete(id);
	}


}
