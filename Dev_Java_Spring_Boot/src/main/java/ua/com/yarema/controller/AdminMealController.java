package ua.com.yarema.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ua.com.yarema.service.MealService;

@Controller
@RequestMapping("/admin/meal")
public class AdminMealController {
	
	private final MealService service;
	
	public AdminMealController(MealService service) {
		this.service = service;
	}

	@GetMapping
	public String show(Model model) {
		model.addAttribute("ingredients", service.findAllIngredients());
		model.addAttribute("cuisines", service.findAllCafes());
		model.addAttribute("meals", service.findAllViews());
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
			@RequestParam List<String> ingredients) {
		return "redirect:/admin/meal";
	}
}
