package ua.com.yarema.controller;

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
import ua.com.yarema.service.MealService;

@Controller
@RequestMapping("/admin/meal")
@SessionAttributes("meal")
public class AdminMealController {
	
	private final MealService mealService;
	
	@Autowired
	public AdminMealController(MealService service) {
		this.mealService = service;
	}
	
	@ModelAttribute("meal")
	public MealRequest getForm() {
		return new MealRequest();
	}

	@GetMapping
	public String show(Model model) {
		model.addAttribute("ingredients", mealService.findAllIngredients());
		model.addAttribute("cuisines", mealService.findAllCuisines());
		model.addAttribute("meals", mealService.findAllViews());
		model.addAttribute("cafes", mealService.findAllCafes());
		return "meal";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		mealService.delete(id);
		return "redirect:/admin/meal";
	}

	@PostMapping
	public String save(@ModelAttribute("meal") MealRequest mealRequest, SessionStatus status) {
		mealService.save(mealRequest);
		return cancel(status);
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable Integer id, Model model) {
		model.addAttribute("meal", mealService.findOne(id));
		return show(model);	
	}
	
	@GetMapping("/cancel")
	public String cancel(SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "redirect:/admin/meal";
	}
}
