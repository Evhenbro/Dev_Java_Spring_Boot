package ua.com.yarema.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.com.yarema.model.request.CommentRequest;
import ua.com.yarema.repository.MealRepository;
import ua.com.yarema.service.CafeService;
import ua.com.yarema.service.CommentService;
import ua.com.yarema.service.MealService;

@Controller
@RequestMapping("/")
public class MainController {

	private final CafeService cafeService;
	
	private final MealService mealService; 
	
	private final MealRepository mealRepository;
	
	private final CommentService commentService; 
	
	@Autowired
	public MainController(CafeService cafeService, MealService mealService, MealRepository mealRepository, CommentService commentService) {
		this.cafeService = cafeService;
		this.mealService = mealService;
		this.mealRepository = mealRepository;
		this.commentService = commentService;
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
		model.addAttribute("comments", commentService.findAllCommentByCafeId(id));
		return "oneCafe";
	}
	
	@GetMapping("/meal")
	public String showAllMeals(Model model) {
		model.addAttribute("meals", mealService.findAllViews());
		return "allMeal";
	}
	
	@GetMapping("/meal/{id}")
	public String showOneMeal(@PathVariable Integer id, Model model) {
		model.addAttribute("mealById", mealService.findMealViewById(id));
		model.addAttribute("ingredients", mealRepository.finfAllIngredientsByMealId(id));
		model.addAttribute("comments", commentService.findAllCommentByMealId(id));
		return "oneMeal";
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
	
	@ModelAttribute("comment")
	public CommentRequest getFormComment() {
		return new CommentRequest();
	}
	
}
