package com.kk.spring.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kk.spring.boot.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
}
