package ua.com.yarema.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ua.com.yarema.entity.Cafe;
import ua.com.yarema.entity.Cuisine;
import ua.com.yarema.entity.Ingredient;
import ua.com.yarema.entity.Meal;
import ua.com.yarema.repository.CafeRepository;
import ua.com.yarema.repository.CuisineRepository;
import ua.com.yarema.repository.IngredientRepository;
import ua.com.yarema.service.MealService;

@Controller
@RequestMapping("/admin/meal")
public class AdminMealController {
	
	private final MealService service;
	
	@Autowired
	private CuisineRepository cuisineRepository;
	
	@Autowired
	private IngredientRepository ingredientRepository;
	
	@Autowired
	private CafeRepository cafeRepository;
 	
	@Autowired
	public AdminMealController(MealService service) {
		this.service = service;
	}

	@GetMapping
	public String show(Model model) {
		model.addAttribute("ingredients", service.findAllIngredients());
		model.addAttribute("cuisines", service.findAllCuisines());
		model.addAttribute("meals", service.findAllViews());
		model.addAttribute("cafes", service.findAllCafes());
		return "meal";
	}
	
	@GetMapping("/delete/{id}")
	public String show(@PathVariable Integer id) {
		service.delete(id);
		return "redirect:/admin/meal";
	}

	@PostMapping
	public String save(@RequestParam String title,
			@RequestParam String description,
			@RequestParam BigDecimal price,
			@RequestParam int weight,
			@RequestParam String cuisine,
			@RequestParam List<String> ingredients,
			@RequestParam String cafe) {
		Cuisine cuisine2 = cuisineRepository.findByName(cuisine);
		List<Ingredient> ingredients2 = ingredientRepository.findAll(ingredients);
		Cafe cafe2 = cafeRepository.findByName(cafe);
		Meal meal = new Meal(title, description, price, cuisine2, weight, ingredients2, cafe2);
		service.save(meal);
		return "redirect:/admin/meal";
	}
}
