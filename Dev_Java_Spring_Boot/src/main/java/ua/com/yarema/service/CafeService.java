package ua.com.yarema.service;

import java.security.Principal;
import java.util.List;

import ua.com.yarema.entity.Cafe;
import ua.com.yarema.model.request.CafeRequest;
import ua.com.yarema.model.view.CafeShortView;
import ua.com.yarema.model.view.CafeView;

public interface CafeService {

	void save(CafeRequest cafeRequest, Principal principal);

	CafeRequest findOne(Integer id);
	
	void delete(Integer id);

	List<CafeShortView> findAllCafeShortView();
	
	List<CafeView> findAllCafeView();

	List<Cafe> findAllCafes();

	CafeView findCafeViewById(Integer id);
	
	List<CafeShortView> findOneCafeShortViewById(Integer id);

	List<CafeShortView> findAllOwnCafesByUserLogin(String login);
}
