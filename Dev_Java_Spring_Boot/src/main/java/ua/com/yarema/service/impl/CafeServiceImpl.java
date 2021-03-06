package ua.com.yarema.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import ua.com.yarema.entity.Cafe;
import ua.com.yarema.entity.Type;
import ua.com.yarema.model.filter.CafeFilter;
import ua.com.yarema.model.filter.SimpleFilter;
import ua.com.yarema.model.request.CafeRequest;
import ua.com.yarema.model.view.CafeShortView;
import ua.com.yarema.model.view.CafeView;
import ua.com.yarema.model.view.CommentView;
import ua.com.yarema.repository.CafeRepository;
import ua.com.yarema.repository.CommentRepository;
import ua.com.yarema.repository.OpenCloseRepository;
import ua.com.yarema.repository.UserRepository;
import ua.com.yarema.repository.impl.OwnCafeViewRepositoryImpl;
import ua.com.yarema.service.CafeService;

@Service
public class CafeServiceImpl implements CafeService {

	private final CafeRepository cafeRepository;
	
	private final UserRepository userRepository; 
	
	private final CommentRepository commentRepository;
	
	private final OpenCloseRepository openCloseRepository;
	
	private final OwnCafeViewRepositoryImpl ownCafeViewRepositoryImpl;
	
	@Autowired
	public CafeServiceImpl(CafeRepository cafeRepository, UserRepository userRepository, CommentRepository commentRepository,OpenCloseRepository openCloseRepository, OwnCafeViewRepositoryImpl ownCafeViewRepositoryImpl) {
		this.cafeRepository = cafeRepository;
		this.userRepository = userRepository;
		this.commentRepository = commentRepository;
		this.openCloseRepository = openCloseRepository;
		this.ownCafeViewRepositoryImpl = ownCafeViewRepositoryImpl;
	}

	@Override
	public void save(CafeRequest cafeRequest, Principal principal) {
		Cafe cafe = new Cafe();
		cafe.setAddress(cafeRequest.getAddress());
//		cafe.setClose(openCloseRepository.findByTime(LocalTime.parse(cafeRequest.getClose())));
		cafe.setClose(openCloseRepository.findByTime(cafeRequest.getClose()));
		cafe.setEmail(cafeRequest.getEmail());
		cafe.setFullDescription(cafeRequest.getFullDescription());
		cafe.setShortDescription(cafeRequest.getShortDescription());
		cafe.setId(cafeRequest.getId());
		cafe.setMeals(cafeRequest.getMeals());
		cafe.setName(cafeRequest.getName());
//		cafe.setOpen(openCloseRepository.findByTime(LocalTime.parse(cafeRequest.getOpen())));
		cafe.setOpen(openCloseRepository.findByTime(cafeRequest.getOpen()));
		cafe.setPhone(cafeRequest.getPhone());
		cafe.setPhotoUrl(cafeRequest.getPhotoUrl());
//		cafe.setRate(new BigDecimal(cafeRequest.getRate()));
		cafe.setType(Type.valueOf(cafeRequest.getType()));
//		cafe.setVersion(Integer.valueOf(cafeRequest.getVersion()));
		cafe.setUser(userRepository.findByLogin(principal.getName()));;
		cafeRepository.save(cafe);
	}

	@Override
	public CafeRequest findOne(Integer id) {
		Cafe cafe = cafeRepository.findOneRequest(id);
		CafeRequest cafeRequest = new CafeRequest();
		cafeRequest.setAddress(cafe.getAddress());
//		cafeRequest.setClose(cafe.getClose().toString());
		cafeRequest.setClose(cafe.getClose().getTime());
		cafeRequest.setEmail(cafe.getEmail());
		cafeRequest.setFullDescription(cafe.getFullDescription());
		cafeRequest.setShortDescription(cafe.getShortDescription());
		cafeRequest.setId(cafe.getId());
		cafeRequest.setMeals(cafe.getMeals());
		cafeRequest.setName(cafe.getName());
//		cafeRequest.setOpen(cafe.getOpen().toString());
		cafeRequest.setOpen(cafe.getOpen().getTime());
		cafeRequest.setPhone(cafe.getPhone());
		cafeRequest.setPhotoUrl(cafe.getPhotoUrl());
//		cafeRequest.setRate(String.valueOf(cafe.getRate()));
		cafeRequest.setType(String.valueOf(cafe.getType()));
//		cafeRequest.setVersion(Integer.valueOf(cafe.getVersion()));
		cafeRequest.setUser(cafe.getUser());
		return cafeRequest;
	}

	@Override
	public void delete(Integer id) {
		cafeRepository.delete(id);
	}

	@Override
	public List<CafeShortView> findAllCafeShortView() {
		return cafeRepository.findAllCafeShortView();
	}

	@Override
	public List<Cafe> findAllCafes() {
		return cafeRepository.findAllCafes();
	}

	@Override
	public List<CafeView> findAllCafeView() {
		return cafeRepository.findAllCafeView();
	}

	@Override
	public CafeView findCafeViewById(Integer id) {
		return cafeRepository.findCafeViewById(id);
	}

	@Override
	public List<CafeShortView> findAllOwnCafesByUserLogin(String login) {
		return cafeRepository.findAllOwnCafesByUserLogin(login);
	}

	@Override
	public List<CafeShortView> findOneCafeShortViewById(Integer id) {
		return cafeRepository.findOneCafeShortViewById(id);
	}

	@Override
	public void updateRateToCafeById(Integer id) {
		List<CommentView> listCommentViews = commentRepository.findAllCommentByCafeId(id);
		int count = 1;
		BigDecimal sum = BigDecimal.ZERO;
//		sum = sum.add(cafeRepository.findCafeViewById(id).getRate());
		for (CommentView commentView : listCommentViews) {
			sum = sum.add(commentView.getRate());
			count ++;
		}			
		sum = sum.divide(new BigDecimal(count), 2, RoundingMode.HALF_DOWN);
		Cafe cafe = cafeRepository.findOne(id);
		cafe.setRate(sum);
		cafeRepository.save(cafe);
	}

	@Override
	public List<CafeShortView> topFiveCafeShortView() {
		List<CafeShortView> topCafes = new ArrayList<>();
		List<CafeShortView> cafeShortViews = cafeRepository.findAllCafeShortView();
		if (!cafeShortViews.isEmpty()) {
			for (CafeShortView cafeShortView : cafeShortViews) {
				if (cafeShortView.getRate()==null) {
					cafeShortView.setRate(BigDecimal.ZERO);
				}
			}
		}
		cafeShortViews.sort((e1, e2) -> e2.getRate().compareTo(e1.getRate()));
		if (cafeShortViews.size() > 5) {
			topCafes = cafeShortViews.subList(0, 5);
		} else {
			topCafes = cafeShortViews;
		}
		return topCafes;
	}

	@Override
	public Page<CafeShortView> findAllCafeShortView(Pageable pageable) {
		return cafeRepository.findAllCafeShortView(pageable);
	}

	@Override
	public Page<CafeShortView> findAllOwnCafesByUserLogin(String login, Pageable pageable) {
		return cafeRepository.findAllOwnCafesByUserLogin(login, pageable);
	}

	@Override
	public Page<CafeShortView> findAllCafeShortView(Pageable pageable, SimpleFilter simpleFilter) {
		return cafeRepository.findAll(filter(simpleFilter), pageable);
	}
	
	public Specification<CafeShortView> filter(SimpleFilter simpleFilter) {
		return (root, query, cb) -> {
				if(simpleFilter.getSearch().isEmpty()) return null;
				return cb.like(root.get("name"), simpleFilter.getSearch() + "%");
		};
	}

	@Override
	public Page<CafeShortView> findAll(CafeFilter cafeFilter, Pageable pageable, Principal principal) {
		return ownCafeViewRepositoryImpl.findAll(cafeFilter, pageable, principal);
	}
	
}
