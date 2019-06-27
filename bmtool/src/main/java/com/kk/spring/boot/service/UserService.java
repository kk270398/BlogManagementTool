package com.kk.spring.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.kk.spring.boot.domain.User;
import com.kk.spring.boot.exceptions.UsernameAlreadyExistsException;
import com.kk.spring.boot.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public User saveUser(User newUser) {
		try {
			newUser.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));
			newUser.setUsername(newUser.getUsername());
			newUser.setConfirmPassword("");

		} catch (Exception e) {
			throw new UsernameAlreadyExistsException("The Username " + newUser.getUsername() + " already exists.");
		}
		return userRepository.save(newUser);
	}

}
