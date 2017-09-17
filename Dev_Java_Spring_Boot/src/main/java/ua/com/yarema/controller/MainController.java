package ua.com.yarema.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.com.yarema.model.request.CafeRequest;
import ua.com.yarema.service.CafeService;

@Controller
@RequestMapping("/")
public class MainController {

	private final CafeService cafeService;
	
	@Autowired
	public MainController(CafeService cafeService) {
		this.cafeService = cafeService;
	}

	@GetMapping
	public String index() {
		return "index";
	}
	
	@ModelAttribute("cafe")
	public CafeRequest getForm() {
		return new CafeRequest();
	}
	
	@GetMapping("/cafe")
	public String client(Model model) {
		model.addAttribute("cafeShortView", cafeService.findAllCafeShortView());
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
