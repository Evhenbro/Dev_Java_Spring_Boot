package ua.com.yarema.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ua.com.yarema.entity.Table;

public interface TableRepository extends JpaRepository<Table, Integer> {

	@Query("SELECT c.name FROM Table t LEFT JOIN t.cafe c")
	List<String> findAllCafes();
}
