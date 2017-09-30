package ua.com.yarema.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.com.yarema.model.filter.SimpleFilter;
import ua.com.yarema.model.request.CommentRequest;
import ua.com.yarema.service.CafeService;
import ua.com.yarema.service.CommentService;

@Controller
@RequestMapping("/cafe")
@SessionAttributes("comment")
public class ClientCafeController {

	private final CafeService cafeService;
	
	private final CommentService commentService; 
	
	@Autowired
	public ClientCafeController(CafeService cafeService, CommentService commentService) {
		this.cafeService = cafeService;
		this.commentService = commentService;
	}
	
	@ModelAttribute("filter")
	public SimpleFilter getFilter() {
		return new SimpleFilter();
	}
	
	@GetMapping
	public String showAllCafes(Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter simpleFilter) {
		model.addAttribute("cafeShortView", cafeService.findAllCafeShortView(pageable, simpleFilter));
		return "allCafe";
	}
	
//	To show one cafe
	
	@GetMapping("/{id}")
	public String showOneCafe(@PathVariable Integer id, Model model) {
		cafeService.updateRateToCafeById(id);
		model.addAttribute("cafeById", cafeService.findCafeViewById(id));
		model.addAttribute("comments", commentService.findAllCommentByCafeId(id));
		return "oneCafe";
	}
	
//	For comment to cafe
	
	@ModelAttribute("comment")
	public CommentRequest getFormComment() {
		return new CommentRequest();
	}
	
	@PostMapping("/{id}")
	public String saveCommentToCafe(@ModelAttribute("comment") @Valid CommentRequest commentRequest, BindingResult bindingResult, Model model, @PathVariable Integer id, SessionStatus sessionStatus) {
		if (bindingResult.hasErrors()) return showOneCafe(id, model);
		commentService.saveCommentToCafe(commentRequest, id);
		return cancelCafe(sessionStatus);
	}
	
	@GetMapping("/{id}/cancel")
	public String cancelCafe(SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "redirect:/cafe/{id}";
	}
	
	
}
