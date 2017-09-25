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

import ua.com.yarema.model.request.CommentRequest;
import ua.com.yarema.model.request.TableRequest;
import ua.com.yarema.repository.MealRepository;
import ua.com.yarema.service.CafeService;
import ua.com.yarema.service.CommentService;
import ua.com.yarema.service.MealService;
import ua.com.yarema.service.TableService;

@Controller
@RequestMapping("/cafe")
public class ClientTableReservController {
	
	private final CafeService cafeService;
	
	private final MealService mealService; 
	
	private final MealRepository mealRepository;
	
	private final CommentService commentService; 
	
	private final TableService tableService; 
	
	@Autowired
	public ClientTableReservController(CafeService cafeService, MealService mealService, MealRepository mealRepository, CommentService commentService, TableService tableService) {
		this.cafeService = cafeService;
		this.mealService = mealService;
		this.mealRepository = mealRepository;
		this.commentService = commentService;
		this.tableService = tableService;
	}
	
	@GetMapping("/{id}/tables")
	public String showTables(@PathVariable Integer id, Model model) {
		model.addAttribute("cafe", cafeService.findCafeViewById(id));
		model.addAttribute("tables", tableService.findAllTableViewByCafeId(id));
		return "tableClient";
	}
	
	@ModelAttribute("reserv")
	public TableRequest getFormRezerv() {
		return new TableRequest();
	}
	
	@PostMapping("/{id}/tables/{idTable}")
	public String saveTableReserv(@PathVariable Integer id, @PathVariable Integer idTable, Model model, @ModelAttribute("reserv") TableRequest tableRequest) {
		model.addAttribute("cafe", cafeService.findCafeViewById(id));
		model.addAttribute("reserv", tableService.findOne(idTable));
		TableRequest request = tableService.findOne(idTable);
		request.setUser(tableRequest.getUser());
		request.setUserPhone(tableRequest.getUserPhone());
		tableService.saveReservation(request, idTable);
		return "reservTable";
	} 
	
	@GetMapping("{id}/tables/{idTable}/cancel")
	public String cancelReserv(SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "redirect:/cafe/{id}/tables";
	}
	
}