package ua.com.yarema.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.com.yarema.entity.OpenClose;
import ua.com.yarema.model.filter.SimpleFilter;
import ua.com.yarema.model.request.OpenCloseRequest;

public interface OpenCloseService {

	Page<OpenClose> findAll(Pageable pageable);

	void save(OpenCloseRequest openCloseRequest);

	void delete(Integer id);

	OpenCloseRequest findOne(Integer id);

//	List<LocalTime> findAllTimes();
	
	List<String> findAllTimes();

	Page<OpenClose> findAll(Pageable pageable, SimpleFilter simpleFilter);


}
