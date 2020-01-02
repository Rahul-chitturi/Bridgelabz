package com.bridgelabz.fundoonotes.servceImplementaion;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.bridgelabz.fundoonotes.dto.LoginDetails;
import com.bridgelabz.fundoonotes.dto.Updatepassword;
import com.bridgelabz.fundoonotes.dto.UserDto;
import com.bridgelabz.fundoonotes.model.User;
import com.bridgelabz.fundoonotes.repository.UserRepository;
import com.bridgelabz.fundoonotes.service.Service;
import com.bridgelabz.fundoonotes.utility.JwtGenerator;
import com.bridgelabz.fundoonotes.utility.Utility;

@org.springframework.stereotype.Service
public class ServiceImplementation implements Service {

	private static final Logger LOGGER = LoggerFactory.getLogger(ServiceImplementation.class);

	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ModelMapper modelMapper;
    
	@Autowired
	private JwtGenerator tokenGenerator;
	
	@Override
	public boolean registration(UserDto user) {

		try {
			User userDetails = new User();
			User checkEmailAvailability = userRepository.findOneByEmail(user.getEmail());
			System.out.println(checkEmailAvailability);
			if (checkEmailAvailability == null) {
				userDetails = modelMapper.map(user, User.class);
				userDetails.setCreatedAt();
				userDetails.setPassword(Utility.getEncryPassWord(user.getPassword()));
				userRepository.save(userDetails);
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public User login(LoginDetails loginDetails) {
	
		User userInfo = userRepository.findOneByEmail(loginDetails.getEmail());
		if(userInfo!=null) {
       LOGGER.info("logining user details" + userInfo.getEmail());
		
        if(userInfo.getEmail().equals(loginDetails.getEmail()) ){
        	boolean is_password_matched = Utility.checkPassword(userInfo.getPassword(), loginDetails.getPassword());
        	if(is_password_matched) {
        		return userInfo;
        	}
        	else {
        		return null;
        	}	
        }
		return null;
	}
		return null;
	}


	@Override
	public boolean verify(String token) {
		try {
		LOGGER.info("id in verification" + (long) tokenGenerator.parseJWT(token));
		Long id = (long) tokenGenerator.parseJWT(token);
		Optional<User> userInfo = userRepository.findById(id);
		if (userInfo.isPresent()) {
		userInfo.get().setIs_email_verified(true);
			userRepository.save(userInfo.get());
			return true;
		}
		
		return false;
	}catch (Exception e) {
		return false;
	}
	}

	@Override
	public boolean updatePassword(String token, Updatepassword updatepassword) {
	
		try {
			
		if(updatepassword.getPassword().equals(updatepassword.getConformPassword())){
			long id = tokenGenerator.parseJWT(token);
			Optional<User> isIdAvailable = userRepository.findById(id);
			if(isIdAvailable.isPresent()) {
				isIdAvailable.get().setPassword(Utility.getEncryPassWord((updatepassword.getPassword())));
				userRepository.save(isIdAvailable.get());
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
		
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean isUserAvailable(String email) {
		
		
		User isIdAvailable = userRepository.findOneByEmail(email);
		if(isIdAvailable!=null) {
		 return true;
		}
		
		return false;
	}
}
