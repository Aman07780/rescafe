package com.springboot.web.modal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Dish {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	private String dishName;
	private String typeOfDish;
	private String sweetOrSavory;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDishName() {
		return dishName;
	}
	public void setDishName(String dishName) {
		this.dishName = dishName;
	}
	public String getTypeOfDish() {
		return typeOfDish;
	}
	public void setTypeOfDish(String typeOfDish) {
		this.typeOfDish = typeOfDish;
	}
	public String getSweetOrSavory() {
		return sweetOrSavory;
	}
	public void setSweetOrSavory(String sweetOrSavory) {
		this.sweetOrSavory = sweetOrSavory;
	}
	public Dish(Long id, String dishName, String typeOfDish, String sweetOrSavory) {
		super();
		this.id = id;
		this.dishName = dishName;
		this.typeOfDish = typeOfDish;
		this.sweetOrSavory = sweetOrSavory;
	}
	public Dish() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
