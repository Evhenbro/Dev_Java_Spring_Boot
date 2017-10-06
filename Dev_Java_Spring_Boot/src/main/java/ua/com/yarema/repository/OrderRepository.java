package ua.com.yarema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ua.com.yarema.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

	@Query("SELECT o FROM Order o JOIN o.table t WHERE t.id=?1")
	Order findOrderByTableId(Integer idTable);

}
