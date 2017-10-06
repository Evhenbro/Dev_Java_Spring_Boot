package ua.com.yarema.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.com.yarema.entity.Order;
import ua.com.yarema.model.view.MealView;

public interface OrderService {

	void saveMealsToOrder(Integer idTable, Integer idMeal);

	Page<MealView> saveTableInOrder(Pageable pageable, Integer idTable, Integer idCafe);

	Page<Order> findAllOrders(Pageable pageable);

	void readyStatus(Integer idOrder);

	void acceptedStatus(Integer idOrder);

	void paidStatus(Integer idOrder);

	Page<Order> findAllOrdersByCafeId(Pageable pageable, Integer idCafe);

}
