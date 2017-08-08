package ua.com.yarema.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="_order")
public class Order extends AbstractEntity {
	
	@ManyToMany
	private List<Meal> meals = new ArrayList<>();
	
	@ManyToOne(fetch=FetchType.LAZY)
	private ua.com.yarema.entity.Table table;

	public List<Meal> getMeals() {
		return meals;
	}

	public void setMeals(List<Meal> meals) {
		this.meals = meals;
	}

	public ua.com.yarema.entity.Table getTable() {
		return table;
	}

	public void setTable(ua.com.yarema.entity.Table table) {
		this.table = table;
	}
	
}
