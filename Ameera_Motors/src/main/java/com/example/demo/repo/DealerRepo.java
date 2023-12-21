package com.example.demo.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Dealer;

public interface DealerRepo extends CrudRepository<Dealer, Integer>{

}
