package com.bridgelabz.fundoonotes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.fundoonotes.dto.UserDto;
import com.bridgelabz.fundoonotes.responses.Response;
import com.bridgelabz.fundoonotes.service.Service;

@RestController
public class UserController {

	@Autowired
	private Service userService;
	
	@PostMapping(value = "/users/register")
	private ResponseEntity<Response> registration(@RequestBody UserDto user) {
  
	boolean is_saved_succussefully =  userService.registration(user);
		if(is_saved_succussefully) {
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(new Response("registration successfull", 200, user));
		}else {
			return ResponseEntity.status(HttpStatus.ALREADY_REPORTED)
					.body(new Response("user already exist", 400, user));
		}
	}

}
