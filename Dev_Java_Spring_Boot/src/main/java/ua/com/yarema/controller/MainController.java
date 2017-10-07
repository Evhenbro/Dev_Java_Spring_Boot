package ua.com.yarema.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.com.yarema.model.view.CafeShortView;
import ua.com.yarema.service.CafeService;

@Controller
@RequestMapping("/")
public class MainController {
	
	private final CafeService cafeService;
	
	@Autowired
	public MainController(CafeService cafeService) {
		super();
		this.cafeService = cafeService;
	}

	@GetMapping
	public String index(Model model, Principal principal) {
//		if(principal!=null){
//			model.addAttribute("message", "Hello " + principal.getName() + "!");
//		} else {
//			model.addAttribute("message", "Hello unregistered user!");
//		}
		int i = 5;
		List<CafeShortView> topFives = cafeService.topFiveCafeShortView();
		for (CafeShortView cafeShortView : topFives) {
			model.addAttribute("top"+ i, cafeShortView);
			i--;
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
