package ua.com.yarema.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.com.yarema.model.filter.MealFilter;
import ua.com.yarema.model.request.CommentRequest;
import ua.com.yarema.repository.CafeRepository;
import ua.com.yarema.repository.CuisineRepository;
import ua.com.yarema.repository.MealRepository;
import ua.com.yarema.service.CommentService;
import ua.com.yarema.service.MealService;

@Controller
@RequestMapping("/meal")
@SessionAttributes("comment")
public class ClientMealController {

	private final MealService mealService; 
	
	private final MealRepository mealRepository;
	
	private final CafeRepository cafeRepository;
	
	private final CommentService commentService;

	private final CuisineRepository cuisineRepository; 
	
	@Autowired
	public ClientMealController(MealService mealService, MealRepository mealRepository, CommentService commentService, CafeRepository cafeRepository, CuisineRepository cuisineRepository) {
		this.mealService = mealService;
		this.mealRepository = mealRepository;
		this.commentService = commentService;
		this.cafeRepository = cafeRepository;
		this.cuisineRepository = cuisineRepository;
	}
	
	@ModelAttribute("filterMeal")
	public MealFilter getMealFilter() {
		return new MealFilter();
	}
	
	@GetMapping
	public String showAllMeals(Model model, @PageableDefault Pageable pageable, @ModelAttribute("filterMeal") MealFilter mealFilter) {
		model.addAttribute("meals", mealService.findAll(mealFilter, pageable));
		model.addAttribute("cafes", cafeRepository.findAll());
		model.addAttribute("cuisines", cuisineRepository.findAll());
		return "allMeal";
	}
	
//	To show one meal
	
	@GetMapping("/{id}")
	public String showOneMeal(@PathVariable Integer id, Model model) {
		model.addAttribute("thisCafe", cafeRepository.findByName(mealService.findMealViewById(id).getCafe()));
		model.addAttribute("mealById", mealService.findMealViewById(id));
		model.addAttribute("ingredients", mealRepository.finfAllIngredientsByMealId(id));
		model.addAttribute("comments", commentService.findAllCommentByMealId(id));
		return "oneMeal";
	}
	
//	For comment to meal
	
	@ModelAttribute("comment")
	public CommentRequest getFormComment() {
		return new CommentRequest();
	}
	
	@PostMapping("/{id}")
	public String saveCommentToMeal(@ModelAttribute("comment") @Valid CommentRequest commentRequest, BindingResult bindingResult, @PathVariable Integer id, SessionStatus sessionStatus, Model model) {
		if (bindingResult.hasErrors()) return showOneMeal(id, model);
		commentService.saveCommentToMeal(commentRequest, id);
		return cancelMale(sessionStatus);
	}
	
	@GetMapping("/{id}/cancel")
	public String cancelMale(SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "redirect:/meal/{id}";
	}
	
}
