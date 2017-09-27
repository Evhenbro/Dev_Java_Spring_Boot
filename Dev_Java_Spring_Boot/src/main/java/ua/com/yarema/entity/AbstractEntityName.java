package ua.com.yarema.entity;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

import ua.com.yarema.validation.annotation.UniqueCuisine;

@MappedSuperclass
public abstract class AbstractEntityName extends AbstractEntity {
	
	@UniqueCuisine(message="Така кухня вже існує в БД.")
	@NotBlank(message="Це поле має бути заповненим.")
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z0-9]+| *$", message="Назва має починатись з веливокї літери.")
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
