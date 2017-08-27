package ua.com.yarema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import ua.com.yarema.entity.OpenClose;
import ua.com.yarema.service.OpenCloseService;

@Controller
@RequestMapping("/admin/open_close")
public class AdminOpenCloseController {

	private final OpenCloseService service;
	
	@Autowired
	public AdminOpenCloseController(OpenCloseService service) {
		this.service = service;
	}
	
	@ModelAttribute("open_close")
	public OpenClose getForm(){
		return new OpenClose();
	}
	
	@GetMapping
	public String show(Model model) {
		model.addAttribute("open_closes", service.findAll());
		return "open_close";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		service.delete(id);
		return "redirect:/admin/open_close";
	}
	
	@PostMapping
	public String save(@ModelAttribute("open_close") OpenClose openClose, SessionStatus sessionStatus) {
		service.save(openClose);
		return cancel(sessionStatus);
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable Integer id, Model model){
		model.addAttribute("open_close", service.findOne(id));
		return show(model);
	}
	
	@GetMapping("/cancel")
	public String cancel(SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "redirect:/admin/open_close";
	}
}
