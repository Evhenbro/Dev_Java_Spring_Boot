package ua.com.yarema.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.com.yarema.model.filter.SimpleFilter;
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
	public String show(@PathVariable Integer idCafe, Model model, @PageableDefault Pageable pageable) {
		model.addAttribute("onecafe", cafeService.findOneCafeShortViewById(idCafe));
		model.addAttribute("cafe", cafeService.findCafeViewById(idCafe));
		model.addAttribute("tables", tableService.findAllTableViewByCafeId(idCafe, pageable));
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
	public String update(@PathVariable Integer idCafe, @PathVariable Integer idTable, Model model, Principal principal, @PageableDefault Pageable pageable) {
		model.addAttribute("table", tableService.findOne(idTable));
		return show(idCafe, model, pageable);	
	}
	
	@GetMapping("/cancel")
	public String cancel(SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "redirect:/profile/cafe/{idCafe}/tables";
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