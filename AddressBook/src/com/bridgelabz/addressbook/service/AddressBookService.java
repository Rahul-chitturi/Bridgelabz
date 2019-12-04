package com.bridgelabz.addressbook.service;

import java.io.File;

import org.json.simple.JSONObject;

import com.bridgelabz.addressbook.model.Person;



public interface AddressBookService {

	void store(Person person);

	void edit(File file, String name);

	void delete(File file, String name);

	JSONObject search(File file, String name);

	void addAddressBook(String name);

	void deleteAddressBook(String name);

	File listOfFiles();

}
