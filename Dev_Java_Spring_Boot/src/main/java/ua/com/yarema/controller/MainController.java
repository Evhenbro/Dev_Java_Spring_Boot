package ua.com.yarema.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.com.yarema.model.request.CafeRequest;

@Controller
@RequestMapping("/")
public class MainController {

	@GetMapping
	public String index() {
		return "index";
	}
	
	@ModelAttribute("cafe")
	public CafeRequest getForm() {
		return new CafeRequest();
	}
	
	@GetMapping("/allCafes")
	public String client() {
		return "cafe";
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
