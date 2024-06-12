package com.springboot.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.web.modal.User;
import com.springboot.web.repository.UserRepo;

import exception.UserNotFoundException;

@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {

//	
	@Autowired
	private UserRepo userRepo;

	@PostMapping("/user")
	User newUser(@RequestBody User newUser) {
		return userRepo.save(newUser);
	}

	@GetMapping("/allusers")
	List<User> getAllUser() {
		return userRepo.findAll();
	}

	@GetMapping("/specuser/{id}")
	User getUserById(@PathVariable Long id) {
		return userRepo.findById(id).orElseThrow(() -> new UserNotFoundException("user ", "id", id));
	}

	@PutMapping("/updateuser/{id}")
	User updateUser(@RequestBody User newUser, @PathVariable Long id) {

		User existingUser = getUserById(id);
		existingUser.setUsername(newUser.getUsername());
		existingUser.setName(newUser.getName());
		existingUser.setEmail(newUser.getEmail());
		User exuser = userRepo.save(existingUser);

		return exuser;

	}

	@DeleteMapping("/deleteuser/{id}")
	String deleteUser(@PathVariable Long id) {
		if (!userRepo.existsById(id)) {
			throw new UserNotFoundException("user", "id", id);
		}
		userRepo.deleteById(id);
		return "User with id " + id + "has been deleted success.";
	}
}
