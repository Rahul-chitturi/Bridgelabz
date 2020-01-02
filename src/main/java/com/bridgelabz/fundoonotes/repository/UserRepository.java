package com.bridgelabz.fundoonotes.repository;

import org.springframework.data.repository.CrudRepository;

import com.bridgelabz.fundoonotes.model.User;

public interface UserRepository extends CrudRepository<User ,Long> {
	User findOneByEmail(String email);
}
