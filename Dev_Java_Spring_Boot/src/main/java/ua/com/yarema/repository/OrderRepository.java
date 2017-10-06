package ua.com.yarema.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ua.com.yarema.entity.Meal;
import ua.com.yarema.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

	@Query("SELECT o FROM Order o JOIN o.table t WHERE t.id=?1")
	Order findOrderByTableId(Integer idTable);

	@Query("SELECT m FROM Meal m JOIN m.orders o WHERE o.id=?1")
	List<Meal> findMealByOrderId(Integer id);

   	@Query("SELECT o FROM Order o JOIN o.table t JOIN t.cafe c WHERE c.id=?1")
	Page<Order> findAllOrdersByCafeId(Pageable pageable, Integer idCafe);

}
