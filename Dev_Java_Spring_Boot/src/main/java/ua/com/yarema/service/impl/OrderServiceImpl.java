package ua.com.yarema.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.com.yarema.entity.Meal;
import ua.com.yarema.entity.Order;
import ua.com.yarema.entity.Status;
import ua.com.yarema.model.view.MealView;
import ua.com.yarema.repository.MealRepository;
import ua.com.yarema.repository.OrderRepository;
import ua.com.yarema.repository.TableRepository;
import ua.com.yarema.service.MealService;
import ua.com.yarema.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	private final OrderRepository orderRepository;
	
	private final TableRepository tableRepository;
	
	private final MealRepository mealRepository;
	
	private final MealService mealService;
	
	@Autowired
	public OrderServiceImpl(OrderRepository orderRepository, TableRepository tableRepository, MealRepository mealRepository, MealService mealService) {
		this.orderRepository = orderRepository;
		this.tableRepository = tableRepository;
		this.mealRepository = mealRepository;
		this.mealService = mealService;
	}

	@Override
	public Page<MealView> saveTableInOrder(Pageable pageable, Integer idTable, Integer idCafe) {
		Order order =orderRepository.findOrderByTableId(idTable);
			if(order!=null){
				order.setTable(tableRepository.findOne(idTable));
			}else{
				order = new Order();
				order.setTable(tableRepository.findOne(idTable));
				order.setTotalPrice(BigDecimal.ZERO);
			}
			orderRepository.save(order);
		return mealService.findAllMealsByCafeId(pageable, idCafe);
	}
	
	@Override
	public void saveMealsToOrder(Integer idTable, Integer idMeal) {
		Order order =  orderRepository.findOrderByTableId(idTable);
		order.getMeals().add(mealRepository.findOne(idMeal));
		orderRepository.save(order);
	}

	@Override
	@Transactional(readOnly=true)
	public Page<Order> findAllOrders(Pageable pageable) {
		Page<Order> orders = orderRepository.findAll(pageable);
		orders.forEach(this::loadMeals);
		for (Order order : orders) {
			BigDecimal total = BigDecimal.ZERO;
			List<Meal> meals = order.getMeals();
			for (Meal meal : meals) {
				total = total.add(meal.getPrice());
			}
			order.setTotalPrice(total);
		}
		return orders;
	}
	
	private void loadMeals(Order order) {
		order.setMeals(orderRepository.findMealByOrderId(order.getId()));
	}

	@Override
	public void readyStatus(Integer idOrder) {
		Order order = orderRepository.findOne(idOrder);
		order.setStatus(Status.READY);
		orderRepository.save(order);
	}

	@Override
	public void acceptedStatus(Integer idOrder) {
		Order order = orderRepository.findOne(idOrder);
		order.setStatus(Status.ACCEPTED);
		orderRepository.save(order);
	}

	@Override
	public void paidStatus(Integer idOrder) {
		Order order = orderRepository.findOne(idOrder);
		order.setStatus(Status.PAID);
		orderRepository.save(order);
	}

	@Override
	public Page<Order> findAllOrdersByCafeId(Pageable pageable, Integer idCafe) {
//		return orderRepository.findAllOrdersByCafeId(pageable, idCafe);
		Page<Order> orders = orderRepository.findAllOrdersByCafeId(pageable, idCafe);
		orders.forEach(this::loadMeals);
		for (Order order : orders) {
			BigDecimal total = BigDecimal.ZERO;
			List<Meal> meals = order.getMeals();
			for (Meal meal : meals) {
				total = total.add(meal.getPrice());
			}
			order.setTotalPrice(total);
		}
		return orders;
	}

}
