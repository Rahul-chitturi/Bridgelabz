package com.bridgelabz.fundoonotes.repository;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.bridgelabz.fundoonotes.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	@Query(value = "SELECT created_at, email, first_name, is_email_verified, last_name,last_login_time, mobilenumber, password , id FROM user_details WHERE email = ?", nativeQuery = true)
	User findByEmailAddress(String emailAddress);

	@Query(value = "insert into user_details (created_at, email, first_name, is_email_verified, last_name, mobilenumber, password , last_login_time) values (?, ?, ?, ?, ?, ?, ? ,?)", nativeQuery = true)
	void sava(User user);

	@Query(value = "select created_at, email, first_name, is_email_verified, last_name, mobilenumber, password , id from user_details where id = ? ", nativeQuery = true)
	User findById(long id);

	@Modifying
	@Transactional
	@Query(value = "update user_details set last_login_time  = ? where id = ?", nativeQuery = true)
	void updateLastLoginTime(Date date, long id);

}
