package ua.com.yarema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import ua.com.yarema.model.request.TableRequest;
import ua.com.yarema.model.request.TableReservRequest;
import ua.com.yarema.service.CafeService;
import ua.com.yarema.service.TableService;
import ua.com.yarema.validation.flag.TableReservRequestFlag;

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
	public String showTables(@PathVariable Integer idCafe, Model model, @PageableDefault Pageable pageable) {
		model.addAttribute("cafe", cafeService.findCafeViewById(idCafe));
		model.addAttribute("tables", tableService.findAllTableViewByCafeId(idCafe, pageable));
		return "tableClient";
	}
	
	@ModelAttribute("reserv")
	public TableRequest getForm() {
		return new TableRequest();
	}
	
	@ModelAttribute("reservTable")
	public TableReservRequest getFormTableRezerv() {
		return new TableReservRequest();
	}
	
	@GetMapping("/{idCafe}/tables/{idTable}")
	public String showTableReserv(@PathVariable Integer idCafe, @PathVariable Integer idTable, Model model) {
		model.addAttribute("idCafe", idCafe);
		model.addAttribute("idTable", idTable);
		return "reservTable";
	}
	
	
	@PostMapping("/{idCafe}/tables/{idTable}")
	public String saveTableReserv(@ModelAttribute("reservTable") @Validated(TableReservRequestFlag.class) TableReservRequest tableReservRequest, BindingResult bindingResult, @PathVariable Integer idCafe, @PathVariable Integer idTable, Model model, SessionStatus sessionStatus) {
		System.out.println(bindingResult.getAllErrors());
		if (bindingResult.hasErrors()) return showTableReserv(idCafe, idTable, model);
		tableService.saveReservation(tableReservRequest, idTable);
		return cancelReserv(sessionStatus);
	} 
	
	@GetMapping("{idCafe}/tables/cancel")
	public String cancelReserv(SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "redirect:/cafe/{idCafe}/tables";
	}
	
}
