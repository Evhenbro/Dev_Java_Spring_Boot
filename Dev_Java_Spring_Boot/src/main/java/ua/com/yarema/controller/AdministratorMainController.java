package ua.com.yarema.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/profile")
public class AdministratorMainController {

	@GetMapping
	public String show(Model model, Principal principal) {
		if(principal!=null){
			model.addAttribute("message", "Welcome " + principal.getName() + " to your manager cabinet!");
		}
		return "profile";
	}
	
}
