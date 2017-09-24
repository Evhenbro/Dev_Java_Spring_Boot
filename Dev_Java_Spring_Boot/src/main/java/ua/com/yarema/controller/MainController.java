package ua.com.yarema.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {

	@GetMapping
	public String index(Model model, Principal principal) {
		if(principal!=null){
			model.addAttribute("message", "Hello " + principal.getName() + "!");
		} else {
			model.addAttribute("message", "Hello unregistered user!");
		}
		return "index";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "admin";
	}
	
	@GetMapping("/search")
	public String search() {
		return "search";
	}
	
}
