package com.bridgelabz.fundoonotes.servceImplementaion;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.bridgelabz.fundoonotes.dto.LoginDetails;
import com.bridgelabz.fundoonotes.dto.Updatepassword;
import com.bridgelabz.fundoonotes.dto.UserDto;
import com.bridgelabz.fundoonotes.model.User;
import com.bridgelabz.fundoonotes.repository.UserRepository;
import com.bridgelabz.fundoonotes.service.UserService;
import com.bridgelabz.fundoonotes.utility.JwtGenerator;
import com.bridgelabz.fundoonotes.utility.Utility;

@org.springframework.stereotype.Service
public class UserServiceImplementation implements UserService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImplementation.class);

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private JwtGenerator tokenGenerator;

	@Autowired
	private Utility util;

	@Override
	public boolean registration(UserDto user) {

		try {
			User checkEmailAvailability = userRepository.findByEmailAddress(user.getEmail());
			if (checkEmailAvailability == null) {
				User userDetails = new User(user.getFirstName(), user.getLastName(), user.getEmail(),
						user.getMobilenumber(), user.getPassword());
				userDetails.setCreatedAt();
				userDetails.setLastLoginTime();
				userDetails.setPassword(Utility.getEncryPassWord(user.getPassword()));
				userRepository.inserData(userDetails.getCreatedAt(), userDetails.getEmail(), userDetails.getFirstName(),
						userDetails.getLastName(), userDetails.getMobilenumber(), userDetails.getPassword());
				User userDetailtosendMail = userRepository.findByEmailAddress(user.getEmail());
				String response = "http://localhost:8080/users/verify/"
						+ tokenGenerator.jwtToken(userDetailtosendMail.getId());
				util.sendVerificationEmail(userDetailtosendMail.getEmail(), response);
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public User login(LoginDetails loginDetails) {

		User userInfo = userRepository.findByEmailAddress(loginDetails.getEmail());
		if (userInfo != null) {
			LOGGER.info("logining user details" + userInfo.getEmail());

			if (userInfo.getEmail().equals(loginDetails.getEmail())) {
				if (userInfo.isIs_email_verified() == true) {
					boolean is_password_matched = Utility.checkPassword(userInfo.getPassword(),
							loginDetails.getPassword());
					if (is_password_matched) {
						userRepository.updateLastLoginTime(new Date(), userInfo.getId());
						return userInfo;
					} else {
						return null;
					}
				} else {
					User userDetailtosendMail = userRepository.findByEmailAddress(loginDetails.getEmail());
					String response = "http://localhost:8080/users/verify/"
							+ tokenGenerator.jwtToken(userDetailtosendMail.getId());
					util.sendVerificationEmail(userDetailtosendMail.getEmail(), response);
				}
				return null;
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
			User userInfo = userRepository.findoneById(id);
			if (userInfo != null) {
				if (!userInfo.isIs_email_verified()) {
					userInfo.setIs_email_verified(true);
					userRepository.verify(userInfo.getId());
					return true;
				} else {
					return true;
				}
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean updatePassword(String token, Updatepassword updatepassword) {

		try {

			if (updatepassword.getPassword().equals(updatepassword.getConformPassword())) {
				long id = tokenGenerator.parseJWT(token);
				User isIdAvailable = userRepository.findoneById(id);
				if (isIdAvailable != null) {
					isIdAvailable.setPassword(Utility.getEncryPassWord((updatepassword.getPassword())));
					userRepository.save(isIdAvailable);
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean isUserAvailable(String email) {
		User isIdAvailable = userRepository.findByEmailAddress(email);
		if (isIdAvailable != null && isIdAvailable.isIs_email_verified() == true) {
//			String response = mailresponse.formMessage("http://localhost:8081/users/passwordupdate",
//			generate.jwtToken(isUserAvailable.getUserId()));
//			MailServiceProvider.sendEmail(isUserAvailable.getEmail(), "Update Password", response);
			String response = "http://localhost:8080/users/updatepassword/"
					+ tokenGenerator.jwtToken(isIdAvailable.getId());
			util.sendVerificationEmail(isIdAvailable.getEmail(), response);
			return true;
		}
		return false;
	}
}

//class MailSender {
//
//	
//	
//	public static void sendMail(String Email) {
//		
//		Runnable runEmailService = new Runnable() {
//
//			@Override
//			public void run() {
//				
//				System.out.println(Email);
//				Utility util = new Utility();
//				util.sendVerificationEmail(Email);
//				
//			}
//		};
//		new Thread(runEmailService).start();
//
//	}
//	
//}
