package com.kk.spring.boot.domain;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
public class User {
	@Id
	private String id;
	@NotBlank(message = "Name Is Required")
	private String name;
	@NotBlank(message = "Username Is Required")
	@Email(message = "Username needs to be an email")
	private String username;
	@NotBlank(message = "Password Is Required")
	private String password;
	@Transient
	private String confirmPassword;

	public User() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return username;
	}

	public void setEmail(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
