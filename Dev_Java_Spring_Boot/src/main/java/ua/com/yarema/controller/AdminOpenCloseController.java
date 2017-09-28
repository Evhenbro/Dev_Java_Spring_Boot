package ua.com.yarema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.com.yarema.model.request.OpenCloseRequest;
import ua.com.yarema.service.OpenCloseService;
import ua.com.yarema.validation.flag.OpenCloseFlag;

@Controller
@RequestMapping("/admin/times")
@SessionAttributes("open_close")
public class AdminOpenCloseController {

	private final OpenCloseService openCloseService;
	
	@Autowired
	public AdminOpenCloseController(OpenCloseService service) {
		this.openCloseService = service;
	}
	
	@ModelAttribute("open_close")
	public OpenCloseRequest getForm(){
		return new OpenCloseRequest();
	}

	@GetMapping
	public String show(Model model) {
		model.addAttribute("times", openCloseService.findAll());
		return "times";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		openCloseService.delete(id);
		return "redirect:/admin/times";
	}
	
	@PostMapping
	public String save(@ModelAttribute("open_close") @Validated(OpenCloseFlag.class) OpenCloseRequest openCloseRequest, BindingResult bindingResult, Model model, SessionStatus sessionStatus) {
		if (bindingResult.hasErrors()) return show(model);
		openCloseService.save(openCloseRequest);
		return cancel(sessionStatus);
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable Integer id, Model model) {
		model.addAttribute("open_close", openCloseService.findOne(id));
		return show(model);	
	}
	
	@GetMapping("/cancel")
	public String cancel(SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "redirect:/admin/times";
	}
}
