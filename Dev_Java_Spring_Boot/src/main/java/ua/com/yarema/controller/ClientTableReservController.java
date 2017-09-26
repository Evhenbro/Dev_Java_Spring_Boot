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

import ua.com.yarema.model.request.TableRequest;
import ua.com.yarema.service.CafeService;
import ua.com.yarema.service.TableService;

@Controller
@RequestMapping("/cafe")
public class ClientTableReservController {
	
	private final CafeService cafeService;
	
	private final TableService tableService; 
	
	@Autowired
	public ClientTableReservController(CafeService cafeService, TableService tableService) {
		this.cafeService = cafeService;
		this.tableService = tableService;
	}
	
	@GetMapping("/{idCafe}/tables")
	public String showTables(@PathVariable Integer idCafe, Model model) {
		model.addAttribute("cafe", cafeService.findCafeViewById(idCafe));
		model.addAttribute("tables", tableService.findAllTableViewByCafeId(idCafe));
		return "tableClient";
	}
	
	@ModelAttribute("reserv")
	public TableRequest getFormRezerv() {
		return new TableRequest();
	}
	
	@GetMapping("/{idCafe}/tables/{idTable}")
	public String showTableReserv(@PathVariable Integer idCafe, @PathVariable Integer idTable, Model model) {
		model.addAttribute("cafe", cafeService.findCafeViewById(idCafe));
		model.addAttribute("reserv", tableService.findOne(idTable));
		return "reservTable";
	}
	
	
	@PostMapping("/{idCafe}/tables/{idTable}")
	public String saveTableReserv(@PathVariable Integer idCafe, @PathVariable Integer idTable, Model model, @ModelAttribute("reserv") TableRequest tableRequest, SessionStatus sessionStatus) {
		model.addAttribute("cafe", cafeService.findCafeViewById(idCafe));
		model.addAttribute("reserv", tableService.findOne(idTable));
		TableRequest request = tableService.findOne(idTable);
		request.setUser(tableRequest.getUser());
		request.setUserPhone(tableRequest.getUserPhone());
		tableService.saveReservation(request, idTable);
		return cancelReserv(sessionStatus);
	} 
	
	@GetMapping("{idCafe}/tables/cancel")
	public String cancelReserv(SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "redirect:/cafe/{idCafe}/tables";
	}
	
}
