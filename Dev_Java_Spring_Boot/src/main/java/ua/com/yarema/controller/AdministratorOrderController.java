package ua.com.yarema.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import ua.com.yarema.model.filter.SimpleFilter;
import ua.com.yarema.service.MealService;
import ua.com.yarema.service.OrderService;
import ua.com.yarema.service.TableService;

@Controller
@RequestMapping("/profile")
@SessionAttributes("order")
public class AdministratorOrderController {
	
	private final MealService mealService;
	
	private final TableService tableService;
	
	private final OrderService orderService;

	public AdministratorOrderController(MealService mealService, TableService tableService, OrderService orderService) {
		this.mealService = mealService;
		this.tableService = tableService;
		this.orderService = orderService;
	}

	@GetMapping("/cafe/{idCafe}/tables/{idTable}/order")
	public String makeOrder(Model model, @PageableDefault Pageable pageable, @PathVariable Integer idCafe, @PathVariable Integer idTable) {
		model.addAttribute("cafeMeals", orderService.saveTableInOrder(pageable, idTable, idCafe));
		model.addAttribute("cafeTable", tableService.findOneTable(idTable));
		model.addAttribute("cafeId", idCafe);
		return "order";
	}
	
	@GetMapping("/cafe/{idCafe}/tables/{idTable}/order/{idMeal}")
	public String saveMealsToOrder(Model model, @PathVariable Integer idCafe, @PathVariable Integer idTable, @PathVariable Integer idMeal, @PageableDefault Pageable pageable) {
		orderService.saveMealsToOrder(idTable, idMeal);
		model.addAttribute("cafeMeals", mealService.findAllMealsByCafeId(pageable, idCafe));
		model.addAttribute("cafeTable", tableService.findOneTable(idTable));
		model.addAttribute("cafeId", idCafe);
		return "order";
	}
	
	private String buildParams(Pageable pageable, SimpleFilter filter) {
		StringBuilder buffer = new StringBuilder();
		buffer.append("?page=");
		buffer.append(String.valueOf(pageable.getPageNumber()+1));
		buffer.append("&size=");
		buffer.append(String.valueOf(pageable.getPageSize()));
		if(pageable.getSort()!=null){
			buffer.append("&sort=");
			Sort sort = pageable.getSort();
			sort.forEach((order)->{
				buffer.append(order.getProperty());
				if(order.getDirection()!= Direction.ASC)
				buffer.append(",desc");
			});
		}
		buffer.append("&search=");
		buffer.append(filter.getSearch());
		return buffer.toString();
	}
}
