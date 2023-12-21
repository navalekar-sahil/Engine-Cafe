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
import com.example.demo.model.Dealer;
import com.example.demo.service.DealerService;
import com.example.demo.wrapper.ResponseWrapper;

@RestController
@RequestMapping("/dealer")
public class DealerController {
	@Autowired	
	DealerService dealerService;
	
	
	//get all dealer
	@GetMapping("")
	public ResponseEntity getallDealer() {
		ResponseWrapper responseWrapper = new ResponseWrapper();
		responseWrapper.setMessage("All dealer: ");
		responseWrapper.setData(this.dealerService.getAllDealer());
		return new ResponseEntity(responseWrapper, HttpStatus.CREATED);
	}
	
	//get dealer with id
	@GetMapping("{id}")
	public ResponseEntity getDealerById(@PathVariable int id) {
		ResponseWrapper responseWrapper = new ResponseWrapper();
		responseWrapper.setMessage(" dealer with id: "+id);
		responseWrapper.setData(this.dealerService.getbyId(id));
		return new ResponseEntity(responseWrapper, HttpStatus.CREATED);
	}
	
	//Create dealer
	@PostMapping("")
	public ResponseEntity addDealer(@RequestBody Dealer dealer ) {
		ResponseWrapper responseWrapper = new ResponseWrapper();
		responseWrapper.setMessage("added successfully: ");
		responseWrapper.setData(this.dealerService.addDealer(dealer));
		return new ResponseEntity(responseWrapper, HttpStatus.CREATED);
	}
	
	//Update Dealer
	@PutMapping("{id}")
	public ResponseEntity UpdateDealer(@PathVariable int id,@RequestBody Dealer dealer ) {
		ResponseWrapper responseWrapper = new ResponseWrapper();
		responseWrapper.setMessage("Updated successfully: ");
		responseWrapper.setData(this.dealerService.updateDealer(id, dealer));
		return new ResponseEntity(responseWrapper, HttpStatus.CREATED);
	}
	
	//delete Dealer
	@DeleteMapping("{id}")
	public ResponseEntity deleteDealer(@PathVariable int id) {
		this.dealerService.deleteDealer(id);
		return new ResponseEntity(HttpStatus.OK);
	}
	//========================dealer Address======================================
	
	//add address of dealer
	@PostMapping("/{id}/address")
	public ResponseEntity addAddress(@PathVariable int id,@RequestBody Address address) {
		ResponseWrapper responseWrapper = new ResponseWrapper();
		responseWrapper.setMessage("added successfully: ");
		responseWrapper.setData(this.dealerService.addAddress(id ,address));
		return new ResponseEntity(responseWrapper, HttpStatus.CREATED);
	}
	
	
}
