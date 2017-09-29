package ua.com.yarema.service.impl;


import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ua.com.yarema.entity.OpenClose;
import ua.com.yarema.model.request.OpenCloseRequest;
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
	public Page<OpenClose> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return openCloseRepository.findAll(pageable);
	}

	@Override
	public void delete(Integer id) {
		openCloseRepository.delete(id);
	}
	
	@Override
	public void save(OpenCloseRequest openCloseRequest) {
		OpenClose openClose = new OpenClose();
		openClose.setId(openCloseRequest.getId());
		openClose.setTime(LocalTime.parse(openCloseRequest.getTime()));
		openCloseRepository.save(openClose);
	}

	@Override
	public OpenCloseRequest findOne(Integer id) {
		OpenClose openClose = openCloseRepository.findOneRequest(id);
		OpenCloseRequest openCloseRequest = new OpenCloseRequest();
		openCloseRequest.setId(openClose.getId());
		openCloseRequest.setTime(openClose.getTime().format(DateTimeFormatter.ofPattern("HH:mm")));
		return openCloseRequest;
	}

	@Override
	public List<LocalTime> findAllTimes() {
		return openCloseRepository.findAllTimes();
	}



}
