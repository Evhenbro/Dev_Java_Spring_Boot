package ua.com.yarema.service;

import java.security.Principal;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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

	void updateRateToCafeById(Integer id);
	
	List<CafeShortView> topFiveCafeShortView();

	Page<CafeShortView> findAllCafeShortView(Pageable pageable);

	Page<CafeShortView> findAllOwnCafesByUserLogin(String login, Pageable pageable);
}
