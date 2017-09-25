package ua.com.yarema.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
@javax.persistence.Table(name="_table")
public class Table extends AbstractEntity {
	
	private String number;
	
	private int countOfPeople;
	
	private boolean isFree;
	
	private String user;
	
	@Column(length=15)
	private String userPhone;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Cafe cafe;
	
	public Table() {
	}
	
	public Table(String number, int countOfPeople, boolean isFree, String user, String userPhone, Cafe cafe) {
		this.number = number;
		this.countOfPeople = countOfPeople;
		this.isFree = isFree;
		this.user = user;
		this.userPhone = userPhone;
		this.cafe = cafe;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public int getCountOfPeople() {
		return countOfPeople;
	}

	public void setCountOfPeople(int countOfPeople) {
		this.countOfPeople = countOfPeople;
	}

	public boolean getIsFree() {
		return isFree;
	}

	public void setIsFree(boolean isFree) {
		this.isFree = isFree;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public Cafe getCafe() {
		return cafe;
	}

	public void setCafe(Cafe cafe) {
		this.cafe = cafe;
	}
	
}
