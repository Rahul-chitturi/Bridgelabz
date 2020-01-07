package com.bridgelabz.fundoonotes.service;

import javax.validation.Valid;

import com.bridgelabz.fundoonotes.dto.LoginDetails;
import com.bridgelabz.fundoonotes.dto.Updatepassword;
import com.bridgelabz.fundoonotes.dto.UserDto;
import com.bridgelabz.fundoonotes.model.User;

public interface UserService {

	User registration(UserDto user);
//	boolean findOneByEmail(String email);

	User login(@Valid LoginDetails loginDetails);

	User verify(String token);

	boolean updatePassword(String token, Updatepassword updatepassword);

	boolean isUserAvailable(String email);
	
}
