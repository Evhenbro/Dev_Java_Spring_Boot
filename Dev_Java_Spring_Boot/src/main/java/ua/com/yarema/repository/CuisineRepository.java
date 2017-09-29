package ua.com.yarema.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ua.com.yarema.entity.Cuisine;

public interface CuisineRepository extends JpaNameRepository<Cuisine>, JpaSpecificationExecutor<Cuisine> {

}
