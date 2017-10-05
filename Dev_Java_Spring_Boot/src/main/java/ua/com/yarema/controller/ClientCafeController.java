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

import ua.com.yarema.model.filter.CafeFilter;
import ua.com.yarema.model.request.CommentRequest;
import ua.com.yarema.repository.CafeViewRepository;
import ua.com.yarema.repository.MealRepository;
import ua.com.yarema.service.CafeService;
import ua.com.yarema.service.CommentService;

@Controller
@RequestMapping("/cafe")
@SessionAttributes("comment")
public class ClientCafeController {
	
	private final CafeService cafeService;
	
	private final CommentService commentService; 
	
	private final CafeViewRepository cafeViewRepository;
	
	private final MealRepository mealRepository;
	
	@Autowired
	public ClientCafeController(CafeService cafeService, CommentService commentService, CafeViewRepository cafeViewRepository, MealRepository mealRepository) {
		this.cafeService = cafeService;
		this.commentService = commentService;
		this.cafeViewRepository = cafeViewRepository;
		this.mealRepository = mealRepository;
	}
	
	@ModelAttribute("cafeFilter")
	public CafeFilter getCafeFilter() {
		return new CafeFilter();
	}
	
	@GetMapping
	public String showAllCafes(Model model, @PageableDefault Pageable pageable, @ModelAttribute("cafeFilter") CafeFilter cafeFilter) {
		model.addAttribute("cafes", cafeViewRepository.findAll(cafeFilter, pageable));
		model.addAttribute("meals", mealRepository.findAll());
		return "allCafe";
	}
	
//	To show one cafe
	
	@GetMapping("/{id}")
	public String showOneCafe(@PathVariable Integer id, Model model) {
		cafeService.updateRateToCafeById(id);
		model.addAttribute("cafeById", cafeService.findCafeViewById(id));
		model.addAttribute("comments", commentService.findAll(id));
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
	
//	For comment to comment
	
	@ModelAttribute("commentToComment")
	public CommentRequest getFormCommentToComment() {
		return new CommentRequest();
	}
	
	@PostMapping("/{id}/{idComment}")
	public String saveCommentToComment(@ModelAttribute("commentToComment") @Valid CommentRequest commentRequest, BindingResult bindingResult, Model model, @PathVariable Integer id, @PathVariable Integer idComment, SessionStatus sessionStatus) {
		if (bindingResult.hasErrors()) return showOneCafe(id, model);
		commentService.saveCommentToCommentCafe(commentRequest, idComment);
		return cancelCafe(sessionStatus);
	}
	
}
