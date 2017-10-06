package ua.com.yarema.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.com.yarema.model.view.MealView;

public interface OrderService {

	void saveMealsToOrder(Integer idTable, Integer idMeal);

	Page<MealView> saveTableInOrder(Pageable pageable, Integer idTable, Integer idCafe);

}
