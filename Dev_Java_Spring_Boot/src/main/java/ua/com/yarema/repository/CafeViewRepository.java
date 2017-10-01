package ua.com.yarema.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.com.yarema.model.filter.CafeFilter;
import ua.com.yarema.model.view.CafeShortView;

public interface CafeViewRepository {
	
	Page<CafeShortView> findAll(CafeFilter cafeFilter, Pageable pageable);
}
