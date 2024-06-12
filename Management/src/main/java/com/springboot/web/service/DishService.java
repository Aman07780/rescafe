package com.springboot.web.service;
 
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.web.modal.Dish;
import com.springboot.web.repository.DishRepository;

import exception.UserNotFoundException;
 
@Service
public class DishService {
 
	@Autowired
	private DishRepository dishRepository;
 
	public Dish newDish(Dish dish) {
		return dishRepository.save(dish);
	}
 
	public List<Dish> getAllDishs() {
		return dishRepository.findAll();
	}
 
	public Dish getDishById(Long id) {
		Optional<Dish> dishOptional = dishRepository.findById(id);
		if (!dishOptional.isPresent()) {
			throw new UserNotFoundException("Dish", "id", id);
		}
		return dishOptional.get();
	}
 
	public Dish updateDish(Long id, Dish newDish) {
		Dish existingDish = getDishById(id);
		existingDish.setDishName(newDish.getDishName());
		existingDish.setTypeOfDish(newDish.getTypeOfDish());
		existingDish.setSweetOrSavory(newDish.getSweetOrSavory());
		return dishRepository.save(existingDish);
	}
 
	public void deleteDish(Long id) {
		if (!dishRepository.existsById(id)) {
			throw new UserNotFoundException("Dish", "id", id);
		}
		dishRepository.deleteById(id);
	}
 
	public Dish findDishByName(String dishName) {
		return dishRepository.findByDishName(dishName);
	}
}