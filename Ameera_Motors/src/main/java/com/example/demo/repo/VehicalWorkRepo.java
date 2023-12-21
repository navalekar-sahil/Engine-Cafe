package com.example.demo.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.VehicalWork;

public interface VehicalWorkRepo extends CrudRepository<VehicalWork, Integer> {
	
	public VehicalWork findBypartName(String name);

}
