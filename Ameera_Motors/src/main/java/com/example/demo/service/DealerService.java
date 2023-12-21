package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.model.Address;
import com.example.demo.model.Dealer;
import com.example.demo.model.Worker;
import com.example.demo.repo.AddressRepo;
import com.example.demo.repo.DealerRepo;

@Service
public class DealerService {

	@Autowired
	DealerRepo dealerRepo;

	@Autowired
	AddressRepo addressRepo;

	// find user
	public Dealer getByDealer(int id) {
		return this.dealerRepo.findById(id).orElseThrow(() -> {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "vehical not found");
		});
	}

	// create new dealer
	public Dealer addDealer(Dealer dealer) {
		return this.dealerRepo.save(dealer);
	}

	// get All Dealer
	public Iterable<Dealer> getAllDealer() {
		return this.dealerRepo.findAll();
	}

	// update dealer
	public Dealer updateDealer(int id, Dealer dealer) {
		Dealer dealerData = getByDealer(id);
		dealer.setId(id);
		dealer.setAddress(dealerData.getAddress());
		return this.dealerRepo.save(dealer);
	}

	// get by id
	public Dealer getbyId(int id) {
		return this.dealerRepo.findById(id).orElseThrow(() -> {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "vehical not found");
		});
	}

	//delete address
	public void deleteDealer(int id) {
		Dealer dealer = getByDealer(id);
		this.addressRepo.deleteById(id);
	}
	
	
	// =================Add Addersss====================

	// add address
	public Address addAddress(int id, Address address) {
		Dealer dealer = getByDealer(id);
		Address AddressData = this.addressRepo.save(address);
		dealer.setAddress(AddressData);
		this.dealerRepo.save(dealer);
		return AddressData;

	}

}
