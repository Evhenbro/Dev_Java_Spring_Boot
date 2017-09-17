package ua.com.yarema.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import ua.com.yarema.entity.Cafe;
import ua.com.yarema.model.view.CafeShortView;
import ua.com.yarema.model.view.CafeView;

public interface CafeRepository extends JpaNameRepository<Cafe> {
	
	@Query("SELECT new ua.com.yarema.model.view.CafeView(cafe.id, cafe.rate, cafe.name, cafe.photoUrl, cafe.version, cafe.address, cafe.fullDescription, cafe.type, cafe.phone, cafe.email, open.time, close.time) FROM Cafe cafe JOIN cafe.open open JOIN cafe.close close")
	List<CafeView> findAllCafeView();

	@Query("SELECT new ua.com.yarema.model.view.CafeShortView(c.id, c.rate, c.name, c.photoUrl, c.version, c.address, c.shortDescription, c.type) FROM Cafe c")
	List<CafeShortView> findAllCafeShortView();

	@Query("SELECT DISTINCT c FROM Cafe c JOIN FETCH c.open JOIN FETCH c.close WHERE c.id=?1")
	Cafe findOneRequest(Integer id);

	@Query("SELECT c FROM Cafe c LEFT JOIN c.open open LEFT JOIN c.close close")
	List<Cafe> findAllCafes();
}
