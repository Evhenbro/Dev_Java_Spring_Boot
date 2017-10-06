package ua.com.yarema.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="_order")
public class Order extends AbstractEntity {
	
	private BigDecimal totalPrice;
	
	@Enumerated
	private Status status;
	
	@ManyToMany
	private List<Meal> meals = new ArrayList<>();
	
	@ManyToOne(fetch=FetchType.LAZY)
	private ua.com.yarema.entity.Table table;

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

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
