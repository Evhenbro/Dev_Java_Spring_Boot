package ua.com.yarema.repository.impl;

import static org.springframework.data.jpa.repository.query.QueryUtils.toOrders;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import ua.com.yarema.entity.Cafe_;
import ua.com.yarema.entity.Cuisine_;
import ua.com.yarema.entity.Meal;
import ua.com.yarema.entity.Meal_;
import ua.com.yarema.model.filter.MealFilter;
import ua.com.yarema.model.view.MealView;
import ua.com.yarema.repository.MealViewRepository;

@Repository
public class MealViewRepositoryImpl implements MealViewRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Page<MealView> findAll(MealFilter mealFilter, Pageable pageable) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<MealView> cq = cb.createQuery(MealView.class);
		Root<Meal> root = cq.from(Meal.class);
		cq.multiselect(root.get(Meal_.id), root.get(Meal_.title), root.get(Meal_.description), root.get(Meal_.price), root.get(Meal_.photoUrl), root.get(Meal_.version), root.get(Meal_.cuisine), root.get(Meal_.cafe), root.get(Meal_.weight));
		PredicateBuilder builder = new PredicateBuilder(mealFilter, cb, root);
		Predicate predicate = builder.toPredicate();
		if (predicate!=null) cq.where(predicate);
		cq.orderBy(toOrders(pageable.getSort(), root, cb));
		List<MealView> content = em.createQuery(cq)
				.setFirstResult(pageable.getPageNumber())
				.setMaxResults(pageable.getPageSize())
				.getResultList();
		CriteriaQuery<Long> cqCount = cb.createQuery(Long.class);
		Root<Meal> rootCount = cqCount.from(Meal.class);
		cqCount.select(cb.count(rootCount));
		PredicateBuilder builderCount = new PredicateBuilder(mealFilter, cb, rootCount);
		Predicate predicateCount = builderCount.toPredicate();
		if(predicateCount!=null) cqCount.where(predicateCount);
		return PageableExecutionUtils.getPage(content, pageable, ()->em.createQuery(cqCount).getSingleResult());
	}
	
	private static class PredicateBuilder {
		
		final MealFilter mealFilter;
		
		final CriteriaBuilder cb;
		
		final Root<Meal> root;
		
		final List<Predicate> predicates = new ArrayList<>();

		public PredicateBuilder(MealFilter mealFilter, CriteriaBuilder cb, Root<Meal> root) {
			this.mealFilter = mealFilter;
			this.cb = cb;
			this.root = root;
		}
		
		void findByTitle() {
			if (!mealFilter.getSearch().isEmpty()) {
				predicates.add(cb.like(root.get(Meal_.title), mealFilter.getSearch() + "%"));
			}
		}
		
		void findByMinPrice() {
			if (!mealFilter.getMinPrice().isEmpty()) {
				predicates.add(cb.ge(root.get(Meal_.price), new BigDecimal(mealFilter.getMinPrice().replace(',', '.'))));
			}
		}
		
		void findByMaxPrice() {
			if (!mealFilter.getMaxPrice().isEmpty()) {
				predicates.add(cb.le(root.get(Meal_.price), new BigDecimal(mealFilter.getMaxPrice().replace(',', '.'))));
			}
		}
		
		void findByCafes() {
			if (!mealFilter.getCafeId().isEmpty()) {
				predicates.add(root.get(Meal_.cafe).get(Cafe_.id).in(mealFilter.getCafeId()));
			}
		}
		
		void findByCuisines() {
			if (!mealFilter.getCuisineId().isEmpty()) {
				predicates.add(root.get(Meal_.cuisine).get(Cuisine_.id).in(mealFilter.getCuisineId()));
			}
		}
		
		Predicate toPredicate() {
			findByTitle();
			findByMinPrice();
			findByMaxPrice();
			findByCafes();
			findByCuisines();
			return cb.and(predicates.toArray(new Predicate[predicates.size()]));
		}
	}

}
