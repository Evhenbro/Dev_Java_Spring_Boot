package ua.com.yarema.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.yarema.entity.Order;
import ua.com.yarema.repository.OrderRepository;
import ua.com.yarema.service.OrderService;

@Service
public class OrderServiceImpl extends CrudServiceImpl<Order, Integer> implements OrderService {

	@Autowired
	public OrderServiceImpl(OrderRepository repository) {
		super(repository);
	}

}
