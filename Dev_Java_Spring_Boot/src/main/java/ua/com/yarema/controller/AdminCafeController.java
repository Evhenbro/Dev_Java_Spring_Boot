package ua.com.yarema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import ua.com.yarema.model.request.CafeRequest;
import ua.com.yarema.service.CafeService;

@Controller
@RequestMapping("/admin/cafe")
public class AdminCafeController {
	
	private final CafeService cafeService;
	
	public AdminCafeController(CafeService cafeService) {
		super();
		this.cafeService = cafeService;
	}

	@ModelAttribute("cafe")
	public CafeRequest getForm() {
		return new CafeRequest();
	}

	@GetMapping
	public String show(Model model) {
		return "cafe";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		return "redirect:/admin/cafe";
	}
	
	@PostMapping
	public String save(@ModelAttribute("cafe") CafeRequest cafeRequest, SessionStatus sessionStatus) {
		cafeService.save(cafeRequest);
		return cancel(sessionStatus);
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable Integer id, Model model) {
		model.addAttribute("cafe", cafeService.findOne(id));
		return show(model);
	}
	
	@GetMapping("/cancel")
	public String cancel(SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "redirect:/admin/meal";
	}
}
