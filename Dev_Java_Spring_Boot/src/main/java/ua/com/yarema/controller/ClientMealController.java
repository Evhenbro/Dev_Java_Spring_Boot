package ua.com.yarema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.com.yarema.model.filter.SimpleFilter;
import ua.com.yarema.model.request.CommentRequest;
import ua.com.yarema.repository.CafeRepository;
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
	
	@Autowired
	public ClientMealController(MealService mealService, MealRepository mealRepository, CommentService commentService, CafeRepository cafeRepository) {
		this.mealService = mealService;
		this.mealRepository = mealRepository;
		this.commentService = commentService;
		this.cafeRepository = cafeRepository;
	}
	
	@ModelAttribute("filter")
	public SimpleFilter getFilter() {
		return new SimpleFilter();
	}
	
	@GetMapping
	public String showAllMeals(Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter simpleFilter) {
		model.addAttribute("meals", mealService.findAllViews(pageable, simpleFilter));
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
	public String saveCommentToMeal(@ModelAttribute("comment") CommentRequest commentRequest, @PathVariable Integer id, SessionStatus sessionStatus) {
		commentService.saveCommentToMeal(commentRequest, id);
		return cancelMale(sessionStatus);
	}
	
	@GetMapping("/{id}/cancel")
	public String cancelMale(SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "redirect:/meal/{id}";
	}
	
}
