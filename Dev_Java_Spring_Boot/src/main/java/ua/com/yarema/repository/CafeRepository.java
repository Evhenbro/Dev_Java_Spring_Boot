package ua.com.yarema.repository;

import org.springframework.data.jpa.repository.Query;

import ua.com.yarema.entity.Cafe;

public interface CafeRepository extends JpaNameRepository<Cafe> {

	@Query("FROM Cafe WHERE name=?1")
	Cafe findByName(String name);
}
