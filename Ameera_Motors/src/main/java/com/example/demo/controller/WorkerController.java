package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Address;
import com.example.demo.model.Worker;
import com.example.demo.service.WorkerService;
import com.example.demo.wrapper.ResponseWrapper;

@RestController
@RequestMapping("/worker")
public class WorkerController {

	@Autowired
	WorkerService service;

	@GetMapping("")
	public ResponseEntity getAllWorker() {
		ResponseWrapper responseWrapper = new ResponseWrapper();
		responseWrapper.setMessage("All Worker");
		responseWrapper.setData(this.service.getAllWorker());
		return new ResponseEntity(responseWrapper, HttpStatus.OK);
	}

	@GetMapping("{id}")
	public ResponseEntity getAllWorkerById(@PathVariable int id) {
		ResponseWrapper responseWrapper = new ResponseWrapper();
		responseWrapper.setMessage("Worker with id:");
		responseWrapper.setData(this.service.getByWorkerById(id));
		return new ResponseEntity(responseWrapper, HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity createWorker(@RequestBody Worker worker) {
		ResponseWrapper responseWrapper = new ResponseWrapper();
		responseWrapper.setMessage("Worker Created");
		responseWrapper.setData(this.service.createWorker(worker));
		return new ResponseEntity(responseWrapper, HttpStatus.OK);
	}

	@PutMapping("{id}")
	public ResponseEntity updateWorker(@PathVariable int id, @RequestBody Worker worker) {
		ResponseWrapper responseWrapper = new ResponseWrapper();
		responseWrapper.setMessage("Worker data updated successfully :");
		responseWrapper.setData(this.service.updateWorker(id, worker));
		return new ResponseEntity(responseWrapper, HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity deleteWorker(@PathVariable int id) {
		this.service.deleteWorker(id);
		return new ResponseEntity(HttpStatus.OK);
	}

	// ==========================workerAddress===================
	@PostMapping("/{id}/address")
	public ResponseEntity addAddress(@PathVariable int id, @RequestBody Address address) {
		ResponseWrapper responseWrapper = new ResponseWrapper();
		responseWrapper.setMessage("Address Added");
		responseWrapper.setData(this.service.addAddress(id, address));
		return new ResponseEntity(responseWrapper, HttpStatus.OK);
	}

}
