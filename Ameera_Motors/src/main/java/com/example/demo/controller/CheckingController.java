
package com.example.demo.controller;

import javax.sound.sampled.ReverbType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Address;
import com.example.demo.model.Checking;
import com.example.demo.model.VehicalWork;
import com.example.demo.repo.CheckingRepo;
import com.example.demo.service.CheckingService;
import com.example.demo.wrapper.ResponseWrapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/checking")
public class CheckingController {

	@Autowired
	CheckingService service;

	@PostMapping("")
	public ResponseEntity addVehical(@RequestBody @Valid Checking checking) {
		ResponseWrapper responseWrapper = new ResponseWrapper();
		responseWrapper.setMessage("vehical Inserted successfully: ");
		responseWrapper.setData(this.service.insertVehical(checking));
		return new ResponseEntity(responseWrapper, HttpStatus.CREATED);
	}

	@GetMapping("")
	public ResponseEntity getAllVehical() {
		ResponseWrapper responseWrapper = new ResponseWrapper();
		responseWrapper.setMessage("All Vehicals : ");
		responseWrapper.setData(this.service.getAllCheckingVehical());
		return new ResponseEntity(responseWrapper, HttpStatus.OK);
	}

	@GetMapping("{id}")
	public ResponseEntity getVehicalById(@PathVariable int id) {
		ResponseWrapper responseWrapper = new ResponseWrapper();
		responseWrapper.setMessage("vehical data with id :" + id);
		responseWrapper.setData(this.service.getById(id));
		return new ResponseEntity(responseWrapper, HttpStatus.OK);
	}

	@PutMapping("{id}")
	public ResponseEntity updateVehical(@PathVariable int id, @RequestBody Checking checking) {
		ResponseWrapper responseWrapper = new ResponseWrapper();
		responseWrapper.setMessage("data updated successfully");
		responseWrapper.setData(this.service.updateVehical(id, checking));
		return new ResponseEntity(responseWrapper, HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity deleteVehical(@PathVariable int id) {
		ResponseWrapper responseWrapper = new ResponseWrapper();
		this.service.deleteVehical(id);
		return new ResponseEntity(HttpStatus.OK);
	}

	// =====================================Part_inward_outward==============================

	@PostMapping("/{id}/work")
	public ResponseEntity insertPart(@Valid @PathVariable int id, @RequestBody VehicalWork inwardOutward) {
		ResponseWrapper responseWrapper = new ResponseWrapper();
		responseWrapper.setMessage("Work inserted successfully in vahical ID: " + id);
		responseWrapper.setData(this.service.addPart(id, inwardOutward));
		return new ResponseEntity(responseWrapper, HttpStatus.CREATED);
	}

	@GetMapping("/{id}/work")
	public ResponseEntity getAllParts(@PathVariable int id) {
		ResponseWrapper responseWrapper = new ResponseWrapper();
		responseWrapper.setMessage("All work  of vehical id: " + id);
		responseWrapper.setData(this.service.getAllParts(id));
		return new ResponseEntity(responseWrapper, HttpStatus.OK);
	}

	@DeleteMapping("/{id}/{workId}/work")
	public ResponseEntity DeleteWork(@PathVariable int id, @PathVariable int workId) {
		this.service.deleteWork(id, workId);
		return new ResponseEntity(HttpStatus.OK);
	}

	// ========================add address of customer==================
	@PostMapping("/{id}/address")
	public ResponseEntity addAddress(@PathVariable int id, @RequestBody Address address) {
		ResponseWrapper responseWrapper = new ResponseWrapper();
		responseWrapper.setMessage("address added successfully");
		responseWrapper.setData(this.service.addAddress(id, address));
		return new ResponseEntity(responseWrapper, HttpStatus.OK);
	}

	

}
