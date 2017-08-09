package ua.com.yarema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.yarema.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
