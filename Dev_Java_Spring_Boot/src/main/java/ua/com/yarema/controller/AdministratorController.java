package ua.com.yarema.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import ua.com.yarema.service.CafeService;

@Controller
@RequestMapping("/profile")
@SessionAttributes("cafe")
public class AdministratorController {

	private final CafeService cafeService;

	public AdministratorController(CafeService cafeService) {
		this.cafeService = cafeService;
	}
	
	@GetMapping
	public String show(Model model, Principal principal) {
		if(principal!=null){
			model.addAttribute("message", "Welcome " + principal.getName() + " to your manager cabinet!");
		}
		return "profile";
	}
	
	@GetMapping("/cafe")
	public String showAllOwnCafes(Model model, Principal principal) {
		if(principal!=null){
			model.addAttribute("ownCafes", cafeService.findAllOwnCafesByUserLogin(principal.getName()));
		}
		return "ownCafes";
	}
	

	
	
}
