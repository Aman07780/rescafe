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

import com.springboot.web.modal.Userinfo;
import com.springboot.web.service.UserItemServiceImpl;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserItemController {
 
	@Autowired
	private UserItemServiceImpl service;
 
	// Sign Up
	@PostMapping("/post/user")
	public ResponseEntity<Userinfo> signUp(@RequestBody Userinfo ob) throws Exception {
		Userinfo login = service.save(ob);
		return new ResponseEntity<>(login, HttpStatus.CREATED);
	}
 
	// Get all Users
	@GetMapping("/user")
	public ResponseEntity<List<Userinfo>> retrieveAllUsers() throws Exception {
		List<Userinfo> loginList = service.findAllValues();
		return new ResponseEntity<>(loginList, HttpStatus.OK);
	}
 
	// Get User by id
	@GetMapping("/user/{id}")
	public ResponseEntity<Userinfo> retrieveUser(@PathVariable Long id) throws Exception {
		Userinfo login = service.findOne(id);
		return new ResponseEntity<>(login, HttpStatus.OK);
	}
 
	// Delete a user id
	@DeleteMapping("/user/{id}")
	public String deleteUser(@PathVariable Long id) throws Exception {
		service.delete(id);
		return "Record removed Successfully";
	}
 
	@PutMapping("/user")
	public ResponseEntity<Userinfo> updateUser(@RequestBody Userinfo ob) throws Exception {
		Userinfo login = service.update(ob);
		return new ResponseEntity<>(login, HttpStatus.OK);
	}
 
	// Log in
	@GetMapping("/user/{email}/{pass}")
	public Userinfo logIn(@PathVariable String email, @PathVariable String pass) throws Exception {
		Userinfo login = service.logIn(email, pass);
		return login;
	}
 
}
