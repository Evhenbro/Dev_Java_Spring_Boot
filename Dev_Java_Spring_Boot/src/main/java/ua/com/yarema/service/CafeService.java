package ua.com.yarema.service;

import java.util.List;

import ua.com.yarema.entity.Cafe;
import ua.com.yarema.model.request.CafeRequest;
import ua.com.yarema.model.view.CafeShortView;

public interface CafeService {

	void save(CafeRequest cafeRequest);

	CafeRequest findOne(Integer id);
	
	void delete(Integer id);

	List<CafeShortView> findAllCafeShortView();

	List<Cafe> findAllCafes();
}
