package ua.com.yarema.service;

import java.time.LocalTime;
import java.util.List;

import ua.com.yarema.entity.OpenClose;
import ua.com.yarema.model.request.OpenCloseRequest;

public interface OpenCloseService {

	List<OpenClose> findAll();

	void save(OpenCloseRequest openCloseRequest);

	void delete(Integer id);

	OpenCloseRequest findOne(Integer id);

	List<LocalTime> findAllTimes();


}
