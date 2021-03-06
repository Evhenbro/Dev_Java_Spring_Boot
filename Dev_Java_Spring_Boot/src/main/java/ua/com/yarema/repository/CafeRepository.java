package ua.com.yarema.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import ua.com.yarema.entity.Cafe;
import ua.com.yarema.model.view.CafeShortView;
import ua.com.yarema.model.view.CafeView;

public interface CafeRepository extends JpaNameRepository<Cafe>, JpaSpecificationExecutor<CafeShortView> {
	
	@Query("SELECT new ua.com.yarema.model.view.CafeView(cafe.id, cafe.rate, cafe.name, cafe.photoUrl, cafe.version, cafe.address, cafe.fullDescription, cafe.type, cafe.phone, cafe.email, open.time, close.time) FROM Cafe cafe JOIN cafe.open open JOIN cafe.close close")
	List<CafeView> findAllCafeView();

	@Query("SELECT new ua.com.yarema.model.view.CafeShortView(c.id, c.rate, c.name, c.photoUrl, c.version, c.address, c.shortDescription, c.type) FROM Cafe c")
	List<CafeShortView> findAllCafeShortView();

	@Query("SELECT DISTINCT c FROM Cafe c JOIN FETCH c.open JOIN FETCH c.close WHERE c.id=?1")
	Cafe findOneRequest(Integer id);

	@Query("SELECT c FROM Cafe c LEFT JOIN c.open open LEFT JOIN c.close close")
	List<Cafe> findAllCafes();

	@Query("SELECT new ua.com.yarema.model.view.CafeView(cafe.id, cafe.rate, cafe.name, cafe.photoUrl, cafe.version, cafe.address, cafe.fullDescription, cafe.type, cafe.phone, cafe.email, open.time, close.time) FROM Cafe cafe LEFT JOIN cafe.open open LEFT JOIN cafe.close close WHERE cafe.id=?1")
	CafeView findCafeViewById(Integer id);
	
	@Query("SELECT new ua.com.yarema.model.view.CafeShortView(c.id, c.rate, c.name, c.photoUrl, c.version, c.address, c.shortDescription, c.type) FROM Cafe c WHERE c.id=?1")
	List<CafeShortView> findOneCafeShortViewById(Integer id);
	
	@Query("SELECT new ua.com.yarema.model.view.CafeShortView(cafe.id, cafe.rate, cafe.name, cafe.photoUrl, cafe.version, cafe.address, cafe.shortDescription, cafe.type) FROM Cafe cafe LEFT JOIN cafe.user user WHERE user.login=?1")
	List<CafeShortView> findAllOwnCafesByUserLogin(String login);

	@Query(value="SELECT new ua.com.yarema.model.view.CafeShortView(c.id, c.rate, c.name, c.photoUrl, c.version, c.address, c.shortDescription, c.type) FROM Cafe c",
			countQuery="SELECT count(c.id) FROM Cafe c")
	Page<CafeShortView> findAllCafeShortView(Pageable pageable);

	@Query(value="SELECT new ua.com.yarema.model.view.CafeShortView(cafe.id, cafe.rate, cafe.name, cafe.photoUrl, cafe.version, cafe.address, cafe.shortDescription, cafe.type) FROM Cafe cafe LEFT JOIN cafe.user user WHERE user.login=?1",
			countQuery="SELECT count(cafe.id) FROM Cafe cafe LEFT JOIN cafe.user user WHERE user.login=?1")
	Page<CafeShortView> findAllOwnCafesByUserLogin(String login, Pageable pageable);
	
	
}
