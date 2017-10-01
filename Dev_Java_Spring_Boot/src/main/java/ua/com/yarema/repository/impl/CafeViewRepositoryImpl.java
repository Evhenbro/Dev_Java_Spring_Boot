package ua.com.yarema.repository.impl;

import static org.springframework.data.jpa.repository.query.QueryUtils.toOrders;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import ua.com.yarema.entity.Cafe;
import ua.com.yarema.entity.Cafe_;
import ua.com.yarema.entity.Meal;
import ua.com.yarema.entity.Meal_;
import ua.com.yarema.model.filter.CafeFilter;
import ua.com.yarema.model.view.CafeShortView;
import ua.com.yarema.repository.CafeViewRepository;

@Repository
public class CafeViewRepositoryImpl implements CafeViewRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Page<CafeShortView> findAll(CafeFilter cafeFilter, Pageable pageable) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<CafeShortView> cq = cb.createQuery(CafeShortView.class);
		Root<Cafe> root = cq.from(Cafe.class);
		cq.multiselect(root.get(Cafe_.id), root.get("rate"), root.get("name"), root.get("photoUrl"), root.get("version"), root.get("address"), root.get("shortDescription"), root.get("type"));
		PredicateBuilder builder = new PredicateBuilder(cafeFilter, cb, root);
		Predicate predicate = builder.toPredicate();
		if (predicate!=null) cq.where(predicate);
		cq.orderBy(toOrders(pageable.getSort(), root, cb));
		List<CafeShortView> content = em.createQuery(cq)
				.setFirstResult(pageable.getPageNumber())
				.setMaxResults(pageable.getPageSize())
				.getResultList();
		CriteriaQuery<Long> cqCount = cb.createQuery(Long.class);
		Root<Cafe> rootCount = cqCount.from(Cafe.class);
		cqCount.select(cb.count(rootCount));
		PredicateBuilder builderCount = new PredicateBuilder(cafeFilter, cb, rootCount);
		Predicate predicateCount = builderCount.toPredicate();
		if(predicateCount!=null) cqCount.where(predicateCount);
		return PageableExecutionUtils.getPage(content, pageable, ()->em.createQuery(cqCount).getSingleResult());
	}
	
	private static class PredicateBuilder {
		
		final CafeFilter cafeFilter;
		
		final CriteriaBuilder cb;
		
		final Root<Cafe> root;
		
		final List<Predicate> predicates = new ArrayList<>();

		public PredicateBuilder(CafeFilter cafeFilter, CriteriaBuilder cb, Root<Cafe> root) {
			this.cafeFilter = cafeFilter;
			this.cb = cb;
			this.root = root;
		}

		void findByMinRate() {
			if (!cafeFilter.getMinRate().isEmpty()) {
				predicates.add(cb.ge(root.get("rate"),	new BigDecimal(cafeFilter.getMinRate().replace(',', '.'))));
			}
		}
		
		void findByMaxRate() {
			if (!cafeFilter.getMaxRate().isEmpty()) {
				predicates.add(cb.le(root.get("rate"),	new BigDecimal(cafeFilter.getMaxRate().replace(',', '.'))));
			}
		}
		
		void findByTypes() {
			if (!cafeFilter.getTypes().isEmpty()) {
				predicates.add(root.get("type").in(cafeFilter.getTypes()));
			}
		}
		
		void findByMeals() {
			if (!cafeFilter.getMealsIds().isEmpty()) {
				Join<Cafe, Meal> join = root.join("meals");
				predicates.add(join.get(Meal_.id).in(cafeFilter.getMealsIds()));
			}
		}
		
		void findByName() {
			if (!cafeFilter.getSearch().isEmpty()) {
				predicates.add(cb.like(root.get(Cafe_.name), cafeFilter.getSearch() + "%"));
			}
		}
		
		Predicate toPredicate() {
			findByMinRate();
			findByMaxRate();
			findByTypes();
			findByMeals();
			findByName();
//			return cb.and(predicates.stream().toArray(Predicate[]::new));
			return cb.and(predicates.toArray(new Predicate[predicates.size()]));
		} 
	}

}
