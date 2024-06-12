package com.springboot.web.controller;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.web.modal.Dish;
import com.springboot.web.service.DishService;
 
@RestController
@CrossOrigin(origins = "*")
public class DishController {
 
    @Autowired
    private DishService dishService; 
 
    @PostMapping("/dish")
    public ResponseEntity<Dish> newDish(@RequestBody Dish dish) {
    	Dish newDish = dishService.newDish(dish);
        return new ResponseEntity<>(newDish, HttpStatus.CREATED);
    }
 
    @GetMapping("/dish")
    public ResponseEntity<List<Dish>> getAllDishs() {
        List<Dish> dishs = dishService.getAllDishs();
        return new ResponseEntity<>(dishs, HttpStatus.OK);
    }
 
    @GetMapping("/dish/{id}")
    public ResponseEntity<Dish> getDishById(@PathVariable Long id) {
    	Dish dish = dishService.getDishById(id);
        return new ResponseEntity<>(dish, HttpStatus.OK);
    }
 
    @PutMapping("/dish/{id}")
    public ResponseEntity<Dish> updateDish(@PathVariable Long id, @RequestBody Dish newDish) {
    	Dish updatedDish = dishService.updateDish(id, newDish);
        return new ResponseEntity<>(updatedDish, HttpStatus.OK);
    }
 
 
	@DeleteMapping("/deletedish/{id}")
    public ResponseEntity<String> deleteDish(@PathVariable Long id) {
        dishService.deleteDish(id);
        return new ResponseEntity<>("Dish with id " + id + " has been deleted success.", HttpStatus.OK);
    }
 
 
	 @GetMapping("/findDishByName/{dishName}")
    public ResponseEntity<Dish> findDishByName(@PathVariable String dishName) {
		 Dish dish = dishService.findDishByName(dishName);
        return new ResponseEntity<>(dish, HttpStatus.OK);
    }
}