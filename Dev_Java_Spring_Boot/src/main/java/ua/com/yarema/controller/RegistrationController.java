package ua.com.yarema.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ua.com.yarema.model.request.RegistrationRequest;
import ua.com.yarema.service.UserService;

@Controller
public class RegistrationController {

	private final UserService userService;

	public RegistrationController(UserService userService) {
		this.userService = userService;
	} 
	
	@GetMapping("/registration")
	public String registration(Model model, Boolean decision) {
		model.addAttribute("registration", new RegistrationRequest());
		return "registration";
	}
	
	@PostMapping("/registration")
	public String save(@ModelAttribute("registration") RegistrationRequest registrationRequest, Model model, Boolean decision) {
		if (!registrationRequest.getPassword().equals(registrationRequest.getRepeatPassword())) {
			decision = false;
			return registration(model, decision);
		} else {
			decision = false;
			userService.save(registrationRequest);			
		}
		return "redirect:/login";
	}
	
	@GetMapping("/login")
	public String login(Principal principal) {
		if(principal!=null) System.out.println(principal.getName());
		return "login";
	}
	
	
}
