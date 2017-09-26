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
@RequestMapping("/profile/cafe/{idCafe}/tables")
@SessionAttributes("table")
public class AdministratorTableController {
	
	private final TableService tableService;
	
	private final CafeService cafeService;
	
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
	public String show(@PathVariable Integer idCafe, Model model) {
		model.addAttribute("onecafe", cafeService.findOneCafeShortViewById(idCafe));
		model.addAttribute("cafe", cafeService.findCafeViewById(idCafe));
		model.addAttribute("tables", tableService.findAllTableViewByCafeId(idCafe));
		return "table";
	}
	
	@PostMapping
	public String save(@ModelAttribute("table") TableRequest tableRequest, SessionStatus sessionStatus){
		tableService.save(tableRequest);
		return cancel(sessionStatus);
	}
	
	@GetMapping("/{idTable}")
	public String dereserveTable(@PathVariable Integer idTable) {
		tableService.dereserveTable(idTable);
		return "redirect:/profile/cafe/{idCafe}/tables";
	} 
	
	@GetMapping("/delete/{idTable}")
	public String delete(@PathVariable Integer idCafe, @PathVariable Integer idTable, Model model, Principal principal) {
		tableService.delete(idTable);
		return "redirect:/profile/cafe/{idCafe}/tables";
	}
	
	@GetMapping("/update/{idTable}")
	public String update(@PathVariable Integer idCafe, @PathVariable Integer idTable, Model model, Principal principal) {
		model.addAttribute("table", tableService.findOne(idTable));
		return show(idCafe, model);	
	}
	
	@GetMapping("/cancel")
	public String cancel(SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "redirect:/profile/cafe/{idCafe}/tables";
	}
	
}