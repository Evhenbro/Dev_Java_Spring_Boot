package ua.com.yarema.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.com.yarema.model.request.MealRequest;
import ua.com.yarema.service.CafeService;
import ua.com.yarema.service.MealService;

@Controller
@RequestMapping("/profile/meal")
@SessionAttributes("meal")
public class MealController {
	
	private final MealService mealService;
	
	private final CafeService cafeService;
	
//	private Principal principal;
	
	@Autowired
	public MealController(MealService mealService, CafeService cafeService) {
		this.mealService = mealService;
		this.cafeService = cafeService;
	}
 	
	@GetMapping
	public String showAllOwnMeals(Model model, Principal principal) {
		if(principal!=null){
			model.addAttribute("ownMeals", mealService.findAllOwnMealsByUserLogin(principal.getName()));
		}
		return "ownMeals";
	}

	@ModelAttribute("meal")
	public MealRequest getForm() {
		return new MealRequest();
	}

	@GetMapping("/new")
	public String showForm(Model model, Principal principal) {
		if(principal!=null){
			model.addAttribute("ingredients", mealService.findAllIngredients());
			model.addAttribute("cuisines", mealService.findAllCuisines());
			model.addAttribute("meals", mealService.findAllViews());
			model.addAttribute("cafes", cafeService.findAllOwnCafesByUserLogin(principal.getName()));
		}
		return "addMeals";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		mealService.delete(id);
		return "redirect:/profile/meal";
	}

	@PostMapping
	public String save(@ModelAttribute("meal") MealRequest mealRequest, SessionStatus status) {
		mealService.save(mealRequest);
		return cancel(status);
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable Integer id, Model model, Principal principal) {
		model.addAttribute("meal", mealService.findOne(id));
		return showForm(model, principal);	
	}
	
	@GetMapping("/new/cancel")
	public String cancel(SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "redirect:/profile/meal/new";
	}
}
