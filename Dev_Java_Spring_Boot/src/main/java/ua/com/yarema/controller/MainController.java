package ua.com.yarema.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.com.yarema.service.CafeService;
import ua.com.yarema.service.MealService;

@Controller
@RequestMapping("/")
public class MainController {

	private final CafeService cafeService;
	
	private final MealService mealService; 
	
	@Autowired
	public MainController(CafeService cafeService, MealService mealService) {
		this.cafeService = cafeService;
		this.mealService = mealService;
	}

	@GetMapping
	public String index() {
		return "index";
	}
	
	@GetMapping("/cafe")
	public String showAllCafes(Model model) {
		model.addAttribute("cafeShortView", cafeService.findAllCafeShortView());
		return "allCafe";
	}
	
	@GetMapping("/cafe/{id}")
	public String showOneCafe(@PathVariable Integer id, Model model) {
		model.addAttribute("cafeById", cafeService.findCafeViewById(id));
		return "oneCafe";
	}
	
	@GetMapping("/meal")
	public String showAllMeals(Model model) {
		model.addAttribute("meals", mealService.findAllViews());
		return "allMeal";
	}
	
	@GetMapping("/administrator")
	public String administrator() {
		return "administrator";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "admin";
	}
	
//	@GetMapping("/login")
//	public String login() {
//		return "login";
//	}
//	
//	@GetMapping("/registration")
//	public String registration() {
//		return "registration";
//	}
	
	@GetMapping("/search")
	public String search() {
		return "search";
	}
}
