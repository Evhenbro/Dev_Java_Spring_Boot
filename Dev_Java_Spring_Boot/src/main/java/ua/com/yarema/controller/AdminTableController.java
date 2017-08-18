package ua.com.yarema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.com.yarema.service.TableService;

@Controller
@RequestMapping("/admin/table")
public class AdminTableController {
	
	private final TableService service;

	@Autowired
	public AdminTableController(TableService service) {
		this.service = service;
	}
	
	@GetMapping
	public String show(Model model) {
		model.addAttribute("tables", service.findAll());
		return "table";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		service.delete(id);
		return "redirect:/admin/table";
	}

}
