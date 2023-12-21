package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.model.UserRegister;
import com.example.demo.service.UserServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class UserController {

	@Autowired
	UserServices userService;

	@PostMapping("/register")
	public ResponseEntity register(@RequestBody @Valid UserRegister userRegister) {
		User user = this.userService.register(userRegister);
		return new ResponseEntity(user, HttpStatus.CREATED);
	}
}
