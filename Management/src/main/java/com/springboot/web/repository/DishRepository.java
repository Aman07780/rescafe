package com.springboot.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.web.modal.Dish;

public interface DishRepository extends JpaRepository<Dish,Long> {
  
	Dish findByDishName(String dishName);
}
