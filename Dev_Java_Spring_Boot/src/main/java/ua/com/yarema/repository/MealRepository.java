package ua.com.yarema.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import ua.com.yarema.entity.Meal;
import ua.com.yarema.model.view.MealView;

public interface MealRepository extends JpaRepository<Meal, Integer>, JpaSpecificationExecutor<MealView> {

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
	
	@Query("SELECT new ua.com.yarema.model.view.MealView(meal.id, meal.title, meal.description, meal.price, meal.photoUrl, meal.version, cuisine.name, cafe.name, meal.weight) FROM Meal meal JOIN meal.cuisine cuisine LEFT JOIN meal.cafe cafe WHERE meal.id=?1")
	MealView findMealViewById(Integer id);
	
	@Query("SELECT new ua.com.yarema.model.view.MealView(meal.id, meal.title, meal.description, meal.price, meal.photoUrl, meal.version, cuisine.name, cafe.name, meal.weight) FROM Meal meal JOIN meal.cuisine cuisine LEFT JOIN meal.cafe cafe LEFT JOIN cafe.user user WHERE user.login=?1")
	List<MealView> findAllOwnMealsByUserLogin(String login);

	@Query(value="SELECT new ua.com.yarema.model.view.MealView(m.id, m.title, m.description, m.price, m.photoUrl, m.version, c.name, ca.name, m.weight) FROM Meal m JOIN m.cuisine c JOIN m.cafe ca",
			countQuery="SELECT count(m.id) FROM Meal m JOIN m.cuisine c JOIN m.cafe ca")
	Page<MealView> findAllViews(Pageable pageable);

	@Query(value="SELECT new ua.com.yarema.model.view.MealView(meal.id, meal.title, meal.description, meal.price, meal.photoUrl, meal.version, cuisine.name, cafe.name, meal.weight) FROM Meal meal JOIN meal.cuisine cuisine LEFT JOIN meal.cafe cafe LEFT JOIN cafe.user user WHERE user.login=?1",
			countQuery="SELECT count(meal.id) FROM Meal meal JOIN meal.cuisine cuisine LEFT JOIN meal.cafe cafe LEFT JOIN cafe.user user WHERE user.login=?1")
	Page<MealView> findAllOwnMealsByUserLogin(String name, Pageable pageable);
	
	@Query(value="SELECT new ua.com.yarema.model.view.MealView(meal.id, meal.title, meal.description, meal.price, meal.photoUrl, meal.version, cuisine.name, cafe.name, meal.weight) FROM Meal meal JOIN meal.cuisine cuisine LEFT JOIN meal.cafe cafe WHERE cafe.id=?1", 
			countQuery="SELECT count (meal.id) FROM Meal meal JOIN meal.cuisine cuisine LEFT JOIN meal.cafe cafe WHERE cafe.id=?1")
	Page<MealView> findAllMealsByCafeId(Pageable pageable, Integer idCafe);
}
