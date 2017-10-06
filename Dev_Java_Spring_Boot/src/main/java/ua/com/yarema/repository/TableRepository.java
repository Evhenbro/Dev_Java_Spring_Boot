package ua.com.yarema.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ua.com.yarema.entity.Cafe;
import ua.com.yarema.entity.Table;
import ua.com.yarema.model.view.TableView;

public interface TableRepository extends JpaRepository<Table, Integer> {
	
	@Query("SELECT c FROM Cafe c WHERE c.id=?1")
	Cafe findOneCafeById(Integer id);

	@Query("SELECT DISTINCT t FROM Table t JOIN FETCH t.cafe WHERE t.id=?1")
	Table findOneRequest(Integer id);
	
	@Query("SELECT new ua.com.yarema.model.view.TableView(table.id, table.number, table.countOfPeople, table.isFree, table.user, table.userPhone, cafe.name) FROM Table table JOIN  table.cafe cafe WHERE cafe.id=?1")
	List<TableView> findAllTableViewByCafeId(Integer id);

	@Query(value="SELECT new ua.com.yarema.model.view.TableView(table.id, table.number, table.countOfPeople, table.isFree, table.user, table.userPhone, cafe.name) FROM Table table JOIN  table.cafe cafe WHERE cafe.id=?1",
			countQuery="SELECT count(table) FROM Table table JOIN  table.cafe cafe WHERE cafe.id=?1")
	Page<TableView> findAllTableViewByCafeId(Integer idCafe, Pageable pageable);
	
	@Query("SELECT new ua.com.yarema.model.view.TableView(table.id, table.number, table.countOfPeople, table.isFree, table.user, table.userPhone, cafe.name) FROM Table table WHERE table.id=?1")
	TableView findOneTable(Integer idTable);
}