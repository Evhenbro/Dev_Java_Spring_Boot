package ua.com.yarema.model.request;

import java.util.ArrayList;
import java.util.List;

import ua.com.yarema.entity.Meal;
import ua.com.yarema.entity.OpenClose;

public class CafeRequest {

	private Integer id;
	
	private String rate;
	
	private String name;
	
	private String photoUrl;
	
	private Integer version;
	
	private String address;
	
	private String fullDescription;
	
	private String shortDescription;
	
	private String type;
	
	private String phone;
	
	private String email;
	
	private OpenClose open;
	
	private OpenClose close;
	
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

	public OpenClose getOpen() {
		return open;
	}

	public void setOpen(OpenClose open) {
		this.open = open;
	}

	public OpenClose getClose() {
		return close;
	}

	public void setClose(OpenClose close) {
		this.close = close;
	}

	public List<Meal> getMeals() {
		return meals;
	}

	public void setMeals(List<Meal> meals) {
		this.meals = meals;
	}
	
}
