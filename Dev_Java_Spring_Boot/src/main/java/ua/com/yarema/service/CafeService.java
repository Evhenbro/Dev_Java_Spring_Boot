package ua.com.yarema.service;

import ua.com.yarema.entity.Cafe;
import ua.com.yarema.model.request.CafeRequest;

public interface CafeService extends CrudService<Cafe, Integer> {

	void save(CafeRequest cafeRequest);
}
