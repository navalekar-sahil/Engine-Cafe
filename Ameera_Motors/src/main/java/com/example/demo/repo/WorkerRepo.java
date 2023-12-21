package com.example.demo.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Worker;

public interface WorkerRepo extends CrudRepository<Worker, Integer>{

}
