package com.bridgelabz.fundoonotes.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.fundoonotes.dto.LoginDetails;
import com.bridgelabz.fundoonotes.dto.Updatepassword;
import com.bridgelabz.fundoonotes.dto.UserDto;
import com.bridgelabz.fundoonotes.model.User;
import com.bridgelabz.fundoonotes.responses.Response;
import com.bridgelabz.fundoonotes.responses.UserAuthenticationResponse;
import com.bridgelabz.fundoonotes.service.UserService;
import com.bridgelabz.fundoonotes.utility.JwtGenerator;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private JwtGenerator tokenGenerator;

	@PostMapping(value = "/users/register")
	private ResponseEntity<Response> registration(@Valid @RequestBody UserDto userDto, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(new Response(bindingResult.getAllErrors().get(0).getDefaultMessage(), 400, null));
		} else {
			User user = userService.registration(userDto);
			user.setPassword("*****");
			return user != null
					? ResponseEntity.status(HttpStatus.CREATED)
							.body(new Response("registration successfull", 200, user))
					: ResponseEntity.status(HttpStatus.ALREADY_REPORTED)
							.body(new Response("user already exist", 400, user));
		}
	}

	@PostMapping(value = "/users/login")
	@CachePut(key = "#token", value = "userId")
	private ResponseEntity<UserAuthenticationResponse> login(@Valid @RequestBody LoginDetails loginDetails , BindingResult bindingResult) {
if(bindingResult.hasErrors()) {
	loginDetails.setPassword("****");
	return ResponseEntity.status(HttpStatus.BAD_REQUEST)
			.body(new UserAuthenticationResponse(bindingResult.getAllErrors().get(0).getDefaultMessage(), 400, loginDetails));
}
		User userInformation = userService.login(loginDetails);
		userInformation.setPassword("****");
		return userInformation != null
				? ResponseEntity.status(HttpStatus.OK)
						.body(new UserAuthenticationResponse(tokenGenerator.jwtToken(userInformation.getId()), 200,
								userInformation))
				: ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body(new UserAuthenticationResponse("Login failed", 400, loginDetails));
	}

	@PutMapping("/users/verify/{token}")
	@CachePut(key = "#token", value = "userId")
	private ResponseEntity<Response> userVerification(@PathVariable("token") String token) {
		try {
			User user = userService.verify(token);
			return user != null ? ResponseEntity.status(HttpStatus.OK).body(new Response("verified", 200))
					: ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response("not verified", 400));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	@PostMapping("/users/resetpassword/{token}")
	@CachePut(key = "#token", value = "userId")
	public ResponseEntity<Response> updatePassword(@PathVariable("token") String token,
			@RequestBody Updatepassword pswd) throws Exception {
//		LOGGER.info("Token :"+token);
//		LOGGER.info("New Password :"+pswd.getNewPassword());

		boolean result = userService.updatePassword(token, pswd);

		if (result) {
			return ResponseEntity.status(HttpStatus.ACCEPTED)
					.body(new Response("Password is Update Successfully", 200));
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new Response("Password and Confirm Password doesn't matched", 400));
		}
	}

	@PostMapping("/users/forgotpassword")
	public ResponseEntity<Response> forgotPassword(@RequestParam("email") String email) {
		// LOGGER.info("Email :"+email);

		boolean result = userService.isUserAvailable(email);
		if (result) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(new Response("User Exist", 200));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Response("User Doesn't Exist", 400));
		}
	}
}
