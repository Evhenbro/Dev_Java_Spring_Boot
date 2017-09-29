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

import ua.com.yarema.entity.Ingredient;
import ua.com.yarema.model.filter.SimpleFilter;
import ua.com.yarema.service.IngredientService;
import ua.com.yarema.validation.flag.IngredientFlag;

@Controller
@RequestMapping("/admin/ingredient")
@SessionAttributes("ingredient")
public class AdminIngredientController {
	
	private final IngredientService service;
	
	@Autowired
	public AdminIngredientController(IngredientService service) {
		this.service = service;
	}
	
	@ModelAttribute("ingredient")
	public Ingredient getForm(){
		return new Ingredient();
	}
	
	@ModelAttribute("filter")
	public SimpleFilter getFilter() {
		return new SimpleFilter();
	}
	
	@GetMapping
	public String show(Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter simpleFilter) {
		model.addAttribute("ingredients", service.findAll(pageable, simpleFilter));
		return "ingredient";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter simpleFilter) {
		service.delete(id);
		return "redirect:/admin/ingredient" + buildParams(pageable, simpleFilter);
	}
	
	@PostMapping
	public String save(@ModelAttribute("ingredient") @Validated(IngredientFlag.class) Ingredient ingredient, BindingResult bindingResult, Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter simpleFilter, SessionStatus sessionStatus) {
		if (bindingResult.hasErrors()) return show(model, pageable, simpleFilter);
		service.save(ingredient);
		return cancel(sessionStatus, pageable, simpleFilter);
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable Integer id, Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter simpleFilter) {
		model.addAttribute("ingredient", service.findOne(id));
		return show(model, pageable, simpleFilter);	
	}
	
	@GetMapping("/cancel")
	public String cancel(SessionStatus sessionStatus, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter simpleFilter) {
		sessionStatus.setComplete();
		return "redirect:/admin/ingredient" + buildParams(pageable, simpleFilter);
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
