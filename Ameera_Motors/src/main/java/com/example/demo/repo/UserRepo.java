package com.example.demo.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

//import com.example.demo.Model.User;
import com.example.demo.model.*;

public interface UserRepo extends CrudRepository<User, Integer> {
	
	public Optional<User> findByEmail(String email);

}
