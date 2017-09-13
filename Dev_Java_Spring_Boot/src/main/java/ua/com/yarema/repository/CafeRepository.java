package ua.com.yarema.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import ua.com.yarema.entity.Cafe;
import ua.com.yarema.model.view.CafeShortView;

public interface CafeRepository extends JpaNameRepository<Cafe> {

	@Query("SELECT new ua.com.yarema.model.view.CafeShortView(c.id, c.rate, c.name, c.photoUrl, c.version, c.address, c.shortDescription, c.type) FROM Cafe c")
	List<CafeShortView> findAllCafeShortView();

	@Query("SELECT DISTINCT c FROM Cafe c JOIN FETCH c.open JOIN FETCH c.close WHERE id=?1")
	Cafe findOneRequest(Integer id);

	@Query("SELECT c FROM Cafe c LEFT JOIN c.open open LEFT JOIN c.close close")
	List<Cafe> findAllCafes();
}
