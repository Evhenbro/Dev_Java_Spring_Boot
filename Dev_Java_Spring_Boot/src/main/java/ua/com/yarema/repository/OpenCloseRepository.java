package ua.com.yarema.repository;

import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import ua.com.yarema.entity.OpenClose;

public interface OpenCloseRepository extends JpaRepository<OpenClose, Integer>, JpaSpecificationExecutor<OpenClose> {
	
	OpenClose findByTime(LocalTime time);

	@Query("SELECT openClose.time FROM OpenClose openClose")
	List<String> findAllTimes();

//	@Query("SELECT openClose.time FROM OpenClose openClose")
//	List<LocalTime> findAllTimes();
	
	@Query("SELECT DISTINCT openClose FROM OpenClose openClose WHERE openClose.id=?1")
	OpenClose findOneRequest(Integer id);
	
}
