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

import ua.com.yarema.model.request.TableRequest;
import ua.com.yarema.service.TableService;

@Controller
@RequestMapping("/admin/table")
@SessionAttributes("table")
public class AdminTableController {
	
	private final TableService tableService;

	@Autowired
	public AdminTableController(TableService tableService) {
		this.tableService = tableService;
	}
	
	@ModelAttribute("table")
	public TableRequest getForm() {
		return new TableRequest();
	}
	
	@GetMapping
	public String show(Model model) {
		model.addAttribute("cafes", tableService.findAllCafes());
		model.addAttribute("tables", tableService.findAll());
		return "table";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		tableService.delete(id);
		return "redirect:/admin/table";
	}

	@PostMapping
	public String save(@ModelAttribute("table") TableRequest tableRequest, SessionStatus sessionStatus){
		tableService.save(tableRequest);
		return cancel(sessionStatus);
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable Integer id, Model model) {
		model.addAttribute("table", tableService.findOne(id));
		return show(model);	
	}
	
	@GetMapping("/cancel")
	public String cancel(SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "redirect:/admin/table";
	}
	
}