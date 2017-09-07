package ua.com.yarema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/cafe")
public class AdminCafeController {

	@GetMapping
	public String show(Model model) {
		return "cafe";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		return "redirect:/admin/cafe";
	}
	
	@PostMapping
	public String save() {
		return "redirect:/admin/cafe";
	}
}
