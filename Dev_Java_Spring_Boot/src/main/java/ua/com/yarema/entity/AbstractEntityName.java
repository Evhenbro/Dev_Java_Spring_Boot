package ua.com.yarema.entity;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

import ua.com.yarema.validation.annotation.UniqueCuisine;
import ua.com.yarema.validation.annotation.UniqueIngredient;
import ua.com.yarema.validation.flag.CafeFlag;
import ua.com.yarema.validation.flag.CuisineFlag;
import ua.com.yarema.validation.flag.IngredientFlag;

@MappedSuperclass
public abstract class AbstractEntityName extends AbstractEntity {
	
	@UniqueIngredient(message="Такий інгредієнт вже існує в БД.", groups=IngredientFlag.class)
	@UniqueCuisine(message="Така кухня вже існує в БД.", groups=CuisineFlag.class)
	@NotBlank(message="Це поле має бути заповненим.", groups={IngredientFlag.class, CuisineFlag.class})
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z0-9]+| *$", message="Назва має починатись з веливокї літери.", groups={IngredientFlag.class, CuisineFlag.class})
	private String name;
	
	public AbstractEntityName() {
	}

	public AbstractEntityName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
