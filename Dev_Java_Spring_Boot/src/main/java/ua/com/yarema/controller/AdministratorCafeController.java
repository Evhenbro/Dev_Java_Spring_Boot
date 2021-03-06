package ua.com.yarema.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
//import org.springframework.security.access.prepost.PreAuthorize;
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

import ua.com.yarema.entity.Type;
import ua.com.yarema.model.filter.CafeFilter;
import ua.com.yarema.model.request.CafeRequest;
import ua.com.yarema.service.CafeService;
import ua.com.yarema.service.OpenCloseService;
import ua.com.yarema.validation.flag.CafeFlag;

@Controller
@RequestMapping("/profile/cafe")
@SessionAttributes("cafe")
public class AdministratorCafeController {
	
	private final CafeService cafeService;
	
	private final OpenCloseService openCloseService;
	
	@Autowired
	public AdministratorCafeController(CafeService cafeService, OpenCloseService openCloseService) {
		this.cafeService = cafeService;
		this.openCloseService = openCloseService;
	}

	@ModelAttribute("cafeFilter")
	public CafeFilter getCafeFilter() {
		return new CafeFilter();
	}
	
	@GetMapping
	public String showAllOwnCafes(Model model, Principal principal, @PageableDefault Pageable pageable, @ModelAttribute("cafeFilter") CafeFilter cafeFilter) {
		if(principal!=null){
			model.addAttribute("ownCafes", cafeService.findAll(cafeFilter, pageable, principal));
		}
		return "ownCafes";
	}
	
	@ModelAttribute("cafe")
	public CafeRequest getFormCafe() {
		return new CafeRequest();
	}

	@GetMapping("/new")
	public String showForm(Model model) {
		model.addAttribute("fullCafes", cafeService.findAllCafes());
		model.addAttribute("cafes", cafeService.findAllCafeShortView());
		model.addAttribute("times", openCloseService.findAllTimes());
		model.addAttribute("types", Type.values());
		return "addCafes";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		cafeService.delete(id);
		return "redirect:/profile/cafe";
	}
	
	@PostMapping
//	@PreAuthorize("")
	public String save(@ModelAttribute("cafe") @Validated(CafeFlag.class) CafeRequest cafeRequest, BindingResult bindingResult, Model model, SessionStatus sessionStatus, Principal principal) {
		if (bindingResult.hasErrors()) return showForm(model);
		cafeService.save(cafeRequest, principal);
		return cancel(sessionStatus);
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable Integer id, Model model) {
		model.addAttribute("cafe", cafeService.findOne(id));
		return showForm(model);
	}
	
	@GetMapping("/new/cancel")
	public String cancel(SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "redirect:/profile/cafe/new";
	}
	
}
