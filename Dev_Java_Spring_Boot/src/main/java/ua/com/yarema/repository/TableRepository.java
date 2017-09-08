package ua.com.yarema.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ua.com.yarema.entity.Cafe;
import ua.com.yarema.entity.Table;

public interface TableRepository extends JpaRepository<Table, Integer> {
	
	@Query("SELECT c FROM Cafe c")
	List<Cafe> findAllCafes();
	
	@Query("SELECT new ua.com.yarema.model.view.TableView(t.id, t.countOfPeople, t.isFree, c.name) FROM Table t LEFT JOIN t.cafe c")
	List<Table> findAll();

	@Query("SELECT DISTINCT t FROM Table t JOIN FETCH t.cafe WHERE t.id=?1")
	Table findOneRequest(Integer id);
	
}