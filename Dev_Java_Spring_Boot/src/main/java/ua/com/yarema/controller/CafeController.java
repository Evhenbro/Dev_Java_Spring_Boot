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

import ua.com.yarema.entity.Type;
import ua.com.yarema.model.request.CafeRequest;
import ua.com.yarema.service.CafeService;
import ua.com.yarema.service.OpenCloseService;

@Controller
@RequestMapping("/admin/cafes")
@SessionAttributes("cafe")
public class CafeController {
	
	private final CafeService cafeService;
	
	@Autowired
	private OpenCloseService openCloseService;
	
	@Autowired
	public CafeController(CafeService cafeService) {
		this.cafeService = cafeService;
	}

	@ModelAttribute("cafe")
	public CafeRequest getForm() {
		return new CafeRequest();
	}

	@GetMapping
	public String show(Model model) {
		model.addAttribute("fullCafes", cafeService.findAllCafes());
		model.addAttribute("cafes", cafeService.findAllCafeShortView());
		model.addAttribute("times", openCloseService.findAllTimes());
		model.addAttribute("types", Type.values());
		return "cafes";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		cafeService.delete(id);
		return "redirect:/admin/cafes";
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
		return "redirect:/admin/cafes";
	}
}