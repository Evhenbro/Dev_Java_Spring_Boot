package ua.com.yarema.repository;

import java.security.Principal;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.com.yarema.model.filter.CafeFilter;
import ua.com.yarema.model.view.CafeShortView;

public interface OwnCafeViewRepository {

	Page<CafeShortView> findAll(CafeFilter cafeFilter, Pageable pageable, Principal principal);
}
