package ua.com.yarema.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.com.yarema.entity.Ingredient;

public interface IngredientService extends CrudService<Ingredient, Integer> {

	Page<Ingredient> findAll(Pageable pageable);

}
