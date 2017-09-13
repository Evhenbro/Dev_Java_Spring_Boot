package ua.com.yarema.service;

import java.time.LocalTime;
import java.util.List;

import ua.com.yarema.entity.OpenClose;

public interface OpenCloseService extends CrudService<OpenClose, Integer> {

	List<LocalTime> findAllTimes();

}
