package ua.com.yarema.model.request;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import ua.com.yarema.entity.Meal;
import ua.com.yarema.entity.User;
import ua.com.yarema.validation.flag.CafeFlag;

public class CafeRequest {

	private Integer id;
	
	@NotBlank(message="Це поле має бути заповненим.", groups=CafeFlag.class)
	@Pattern(regexp = "^([0-9]{1}\\.{1}[0-9]{1,2})|([1]{1}[0]{1}\\.{1}[0-9]{1,2})|([0-9]{1})|(10{1})| *$", message="Ви ввели невірний формат(Вірно: 7 або 5.58 та максимум це 10.00).", groups=CafeFlag.class)
	private String rate;
	
	@NotBlank(message="Це поле має бути заповненим.", groups=CafeFlag.class)
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z0-9]+| *$", message="Назва має починатись з веливокї літери.", groups=CafeFlag.class)
	private String name;
	
	@NotBlank(message="Це поле має бути заповненим.", groups=CafeFlag.class)
	private String photoUrl;
	
	private Integer version;
	
	@NotBlank(message="Це поле має бути заповненим.", groups=CafeFlag.class)
	@Pattern(regexp = "^[A-Z]{1}[\\.\\,\\ a-zA-Z0-9]+| *$", message="Адреса має починатись з веливокї літери.", groups=CafeFlag.class)
	private String address;
	
	@NotBlank(message="Це поле має бути заповненим.", groups=CafeFlag.class)
	private String fullDescription;
	
	@NotBlank(message="Це поле має бути заповненим.", groups=CafeFlag.class)
	private String shortDescription;
	
	private String type;
	
	@Pattern(regexp = "^\\+{1}[0-9]{3}[0-9]{6,12}$", message="Введено невірний формат.", groups=CafeFlag.class)
	private String phone;
	
	@NotBlank(message="Це поле має бути заповненим.", groups=CafeFlag.class)
	@Email(message="Введено невірний формат.", groups={CafeFlag.class})
	private String email;
	
	private LocalTime open;
	
	private LocalTime close;
	
	private User user;
	
	private List<Meal> meals = new ArrayList<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFullDescription() {
		return fullDescription;
	}

	public void setFullDescription(String fullDescription) {
		this.fullDescription = fullDescription;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalTime getOpen() {
		return open;
	}

	public void setOpen(LocalTime open) {
		this.open = open;
	}

	public LocalTime getClose() {
		return close;
	}

	public void setClose(LocalTime close) {
		this.close = close;
	}

	public List<Meal> getMeals() {
		return meals;
	}

	public void setMeals(List<Meal> meals) {
		this.meals = meals;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((close == null) ? 0 : close.hashCode());
		result = prime * result + ((open == null) ? 0 : open.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CafeRequest other = (CafeRequest) obj;
		if (close == null) {
			if (other.close != null)
				return false;
		} else if (!close.equals(other.close))
			return false;
		if (open == null) {
			if (other.open != null)
				return false;
		} else if (!open.equals(other.open))
			return false;
		return true;
	}

}
