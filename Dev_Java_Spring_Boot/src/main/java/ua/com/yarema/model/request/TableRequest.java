package ua.com.yarema.model.request;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

import ua.com.yarema.entity.Cafe;
import ua.com.yarema.validation.flag.TableReservFlag;

public class TableRequest {

	private String number;
	
	private Integer id;
	
	private Integer countOfPeople;
	
	private boolean isFree;
	
	@NotBlank(message="Це поле має бути заповненим.", groups=TableReservFlag.class)
	private String user;
	
	@Pattern(regexp = "^\\+{1}[0-9]{3}[0-9]{6,12}$", message="Введено невірний формат.", groups=TableReservFlag.class)
	private String userPhone;
	
	private Cafe cafe;
	
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCountOfPeople() {
		return countOfPeople;
	}

	public void setCountOfPeople(Integer countOfPeople) {
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
