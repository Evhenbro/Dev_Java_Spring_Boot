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

import ua.com.yarema.model.filter.SimpleFilter;
import ua.com.yarema.model.request.OpenCloseRequest;
import ua.com.yarema.service.OpenCloseService;
import ua.com.yarema.validation.flag.OpenCloseFlag;

@Controller
@RequestMapping("/admin/times")
@SessionAttributes("open_close")
public class AdminOpenCloseController {

	private final OpenCloseService openCloseService;
	
	@Autowired
	public AdminOpenCloseController(OpenCloseService service) {
		this.openCloseService = service;
	}
	
	@ModelAttribute("open_close")
	public OpenCloseRequest getForm(){
		return new OpenCloseRequest();
	}
	
	@ModelAttribute("filter")
	public SimpleFilter getFilter() {
		return new SimpleFilter();
	}

	@GetMapping
	public String show(Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter simpleFilter) {
		model.addAttribute("times", openCloseService.findAll(pageable, simpleFilter));
		return "times";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter simpleFilter) {
		openCloseService.delete(id);
		return "redirect:/admin/times" + buildParams(pageable, simpleFilter);
	}
	
	@PostMapping
	public String save(@ModelAttribute("open_close") @Validated(OpenCloseFlag.class) OpenCloseRequest openCloseRequest, BindingResult bindingResult, Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter simpleFilter, SessionStatus sessionStatus) {
		if (bindingResult.hasErrors()) return show(model, pageable, simpleFilter);
		openCloseService.save(openCloseRequest);
		return cancel(sessionStatus, pageable, simpleFilter);
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable Integer id, Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter simpleFilter) {
		model.addAttribute("open_close", openCloseService.findOne(id));
		return show(model, pageable, simpleFilter);	
	}
	
	@GetMapping("/cancel")
	public String cancel(SessionStatus sessionStatus, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter simpleFilter) {
		sessionStatus.setComplete();
		return "redirect:/admin/times" + buildParams(pageable, simpleFilter);
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
