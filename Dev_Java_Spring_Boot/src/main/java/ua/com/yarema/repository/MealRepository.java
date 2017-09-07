package ua.com.yarema.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ua.com.yarema.entity.Meal;
import ua.com.yarema.model.view.MealView;

public interface MealRepository extends JpaRepository<Meal, Integer> {

	@Query("SELECT c.name FROM Cuisine c")
	List<String> findAllCuisines();
	
	@Query("SELECT i.name FROM Ingredient i")
	List<String> findAllIngredients();
	
	@Query("SELECT ca.name FROM Cafe ca")
	List<String> findAllCafes();
			
	@Query("SELECT new ua.com.yarema.model.view.MealView(m.id, m.title, m.description, m.price, m.photoUrl, m.version, c.name, ca.name, m.weight) FROM Meal m JOIN m.cuisine c LEFT JOIN m.cafe ca")
	List<MealView> findAllViews();
	
	@Query("SELECT i.name FROM Ingredient i JOIN i.meals m WHERE m.id=?1")
	List<String> finfAllIngredientsByMealId(Integer id);

	@Query("SELECT DISTINCT m FROM Meal m JOIN FETCH m.cuisine LEFT JOIN FETCH m.ingredients JOIN FETCH m.cafe WHERE m.id=?1")
	Meal findOneRequest(Integer id);
}
