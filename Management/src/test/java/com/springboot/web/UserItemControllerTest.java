package com.springboot.web;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.springboot.web.controller.UserItemController;
import com.springboot.web.modal.Userinfo;
import com.springboot.web.service.UserItemServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserItemControllerTest {

	@InjectMocks
	private UserItemController controller;

	@Mock
	private UserItemServiceImpl service;

	@Test
	public void testSignUp() throws Exception {
		// Arrange
		Userinfo ob = new Userinfo(); // Set the properties of this object as needed
		when(service.save(ob)).thenReturn(ob);

		// Act
		ResponseEntity<Userinfo> response = controller.signUp(ob);

		// Assert
		assertEquals(HttpStatus.CREATED, response.getStatusCode());
		assertEquals(ob, response.getBody());
	}

}