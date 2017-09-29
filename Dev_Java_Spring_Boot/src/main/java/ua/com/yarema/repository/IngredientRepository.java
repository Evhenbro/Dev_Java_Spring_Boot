package ua.com.yarema.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import ua.com.yarema.entity.Ingredient;

public interface IngredientRepository extends JpaNameRepository<Ingredient>, JpaSpecificationExecutor<Ingredient> {

	@Query("FROM Ingredient i WHERE i.name IN ?1")
	List<Ingredient> findAll(List<String> names);
}
