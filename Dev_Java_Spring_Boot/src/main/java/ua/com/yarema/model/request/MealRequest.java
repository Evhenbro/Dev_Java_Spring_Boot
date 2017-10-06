package ua.com.yarema.model.request;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

import ua.com.yarema.entity.Cafe;
import ua.com.yarema.entity.Cuisine;
import ua.com.yarema.entity.Ingredient;

public class MealRequest {

	private Integer id;
	
	@NotBlank(message="Це поле має бути заповненим.")
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z0-9]+| *$", message="Назва має починатись з веливокї літери.")
	private String title;
	
	@NotBlank(message="Це поле має бути заповненим.")
	private String description;
	
	@NotBlank(message="Це поле має бути заповненим.")
	@Pattern(regexp = "^([0-9]{1,3}\\.{1}[0-9]{1,2})|([0-9]{1,3})| *$", message="Ви ввели невірний формат(Вірно: 120 або 95.75).")
	private String price;
	
	private String photoUrl;
	
	private int version; 
	
	private Cuisine cuisine;
	
	private Cafe cafe;
	
	@NotBlank(message="Це поле має бути заповненим.")
	@Pattern(regexp = "^([0-9]{2,3}\\.{1}0{1,2})|([0-9]{2,3})| *$", message="Ви ввели невірний формат(Вірно: 12 або 250.00).")
	private String weight;
	
	private List<Ingredient> ingredients = new ArrayList<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Cuisine getCuisine() {
		return cuisine;
	}

	public void setCuisine(Cuisine cuisine) {
		this.cuisine = cuisine;
	}

	public Cafe getCafe() {
		return cafe;
	}

	public void setCafe(Cafe cafe) {
		this.cafe = cafe;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	
}
