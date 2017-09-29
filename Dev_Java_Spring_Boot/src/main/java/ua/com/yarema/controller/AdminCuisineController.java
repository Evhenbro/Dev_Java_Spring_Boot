package ua.com.yarema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.com.yarema.entity.Cuisine;
import ua.com.yarema.model.filter.SimpleFilter;
import ua.com.yarema.service.CuisineService;
import ua.com.yarema.validation.flag.CuisineFlag;

@Controller
@RequestMapping("/admin/cuisine")
@SessionAttributes("cuisine")
public class AdminCuisineController {
	
	private final CuisineService service;
	
	@Autowired
	public AdminCuisineController(CuisineService service) {
		this.service = service;
	}
	
	@ModelAttribute("cuisine")
	public Cuisine getForm(){
		return new Cuisine();
	}
	
	@ModelAttribute("filter")
	public SimpleFilter getFilter(){
		return new SimpleFilter();
	}
	
	@GetMapping
	public String show(Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter simpleFilter) {
		model.addAttribute("cuisines", service.findAll(pageable, simpleFilter));
		return "cuisine";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter simpleFilter) {
		service.delete(id);
		return "redirect:/admin/cuisine" + buildParams(pageable, simpleFilter);
	}
	
	@PostMapping
	public String save(@ModelAttribute("cuisine") @Validated(CuisineFlag.class) Cuisine cuisine, BindingResult bindingResult, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter simpleFilter, Model model, SessionStatus sessionStatus) {
		if (bindingResult.hasErrors()) return show(model, pageable, simpleFilter);
		service.save(cuisine);
		return cancel(sessionStatus, pageable, simpleFilter);
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable Integer id, Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter simpleFilter){
		model.addAttribute("cuisine", service.findOne(id));
		return show(model, pageable, simpleFilter);
	}
	
	@GetMapping("/cancel")
	public String cancel(SessionStatus sessionStatus, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter simpleFilter) {
		sessionStatus.setComplete();
		return "redirect:/admin/cuisine" + buildParams(pageable, simpleFilter);
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
