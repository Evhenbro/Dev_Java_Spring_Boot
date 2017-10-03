package ua.com.yarema.model.filter;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class MealFilter {

	private static final Pattern PRICE_PATTERN = Pattern.compile("^([0-9]{1,3}.[0-9]{2})|([0-9]{1,3})|(1000{1})|(1000{1}.[0-9]{2})$");
	
	private String search = "";
	
	private String minPrice = "";
	
	private String maxPrice = "";
	
	private List<String> cafeId = new ArrayList<>();
	
	private List<String> cuisineId = new ArrayList<>();

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(String minPrice) {
		if (PRICE_PATTERN.matcher(minPrice).matches())
		this.minPrice = minPrice;
	}

	public String getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(String maxPrice) {
		if (PRICE_PATTERN.matcher(maxPrice).matches())
		this.maxPrice = maxPrice;
	}

	public List<String> getCafeId() {
		return cafeId;
	}

	public void setCafeId(List<String> cafeId) {
		this.cafeId = cafeId;
	}

	public List<String> getCuisineId() {
		return cuisineId;
	}

	public void setCuisineId(List<String> cuisineId) {
		this.cuisineId = cuisineId;
	}

	
}
