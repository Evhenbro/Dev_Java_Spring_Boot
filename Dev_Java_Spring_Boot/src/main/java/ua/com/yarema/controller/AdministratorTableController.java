package ua.com.yarema.controller;

import java.security.Principal;

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
import ua.com.yarema.service.CafeService;
import ua.com.yarema.service.TableService;

@Controller
@RequestMapping("/profile/cafe/{id}/tables")
@SessionAttributes("table")
public class AdministratorTableController {
	
	private final TableService tableService;
	
	private final CafeService cafeService;
	
	private Integer idi = 0;

	@Autowired
	public AdministratorTableController(TableService tableService, CafeService cafeService) {
		this.tableService = tableService;
		this.cafeService = cafeService;
	}
	
	@ModelAttribute("table")
	public TableRequest getForm() {
		return new TableRequest();
	}
	
	@GetMapping
	public String show(@PathVariable Integer id, Model model, Principal principal) {
		if(principal!=null){
			model.addAttribute("ownCafes", cafeService.findAllOwnCafesByUserLogin(principal.getName()));
		}
		System.out.println("/profile/cafe/{id}/tables " + id);
		idi = id;
		model.addAttribute("cafe", cafeService.findCafeViewById(id));
		model.addAttribute("tables", tableService.findAllTableViewByCafeId(id));
		return "table";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id, Model model, Principal principal) {
		System.out.println("/delete/{id} " + id);
		tableService.delete(id);
		id = idi;
		System.out.println("/delete/{id} " + id);
		return "redirect:/profile/cafe/{id}/tables";
	}

	@PostMapping
	public String save(@ModelAttribute("table") TableRequest tableRequest, SessionStatus sessionStatus){
		tableService.save(tableRequest);
		return cancel(sessionStatus);
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable Integer id, Model model, Principal principal) {
		System.out.println("/update/{id} " + id);
		model.addAttribute("table", tableService.findOne(id));
		id = idi;
		return show(id, model, principal);	
	}
	
	@GetMapping("/cancel")
	public String cancel(SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "redirect:/profile/cafe/{id}/tables";
	}
	
}