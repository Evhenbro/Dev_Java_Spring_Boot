package ua.com.yarema.repository;

import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ua.com.yarema.entity.OpenClose;

public interface OpenCloseRepository extends JpaRepository<OpenClose, Integer> {
	
	OpenClose findByTime(LocalTime time);

	@Query("SELECT openClose.time FROM OpenClose openClose")
	List<LocalTime> findAllTimes();
	
}
