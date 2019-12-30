package com.bridgelabz.fundoonotes.servceImplementaion;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.bridgelabz.fundoonotes.dto.UserDto;
import com.bridgelabz.fundoonotes.model.User;
import com.bridgelabz.fundoonotes.repository.UserRepository;
import com.bridgelabz.fundoonotes.service.Service;
import com.bridgelabz.fundoonotes.utility.Utility;

@org.springframework.stereotype.Service
public class ServiceImplementation implements Service {

	@Autowired
	private UserRepository UserRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public boolean registration(UserDto user) {

		try {
			User userDetails = new User();
			userDetails = modelMapper.map(user, User.class);
			userDetails.setCreatedAt();
			userDetails.setPassword(Utility.getEncryPassWord(user.getPassword()));
			UserRepository.save(userDetails);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
