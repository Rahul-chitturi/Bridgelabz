package com.bridgelabz.fundoonotes.dto;


import javax.validation.constraints.NotNull;


public class UserDto {


	private String firstName;
	
	private String lastName;

	@NotNull
	private String email;
	
    @NotNull
	private long mobilenumber;
	
    @NotNull
	private String password;
	

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(long mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
