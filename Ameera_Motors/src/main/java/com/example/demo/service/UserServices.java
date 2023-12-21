package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.model.*;
import com.example.demo.repo.UserRepo;

@Service
public class UserServices {

	@Autowired
	UserRepo userRepo;

	@Autowired
	PasswordEncoder passwordEncoder;

	public User register(UserRegister userRegister) {
		
		if (this.userRepo.findByEmail(userRegister.getEmail()).isPresent()) {
			throw new ResponseStatusException(HttpStatus.ACCEPTED.BAD_REQUEST);
		}

		User user = new User();
		user.setName(userRegister.getName());
		user.setEmail(userRegister.getEmail());
		user.setRoles(userRegister.getRoles());
		user.setPassword(this.passwordEncoder.encode(userRegister.getPassword()));

		return this.userRepo.save(user);
	}

}
