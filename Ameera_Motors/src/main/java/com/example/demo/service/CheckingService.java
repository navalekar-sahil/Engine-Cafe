package com.example.demo.service;

import java.util.List;

import org.apache.catalina.filters.AddDefaultCharsetFilter.ResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.model.Address;
import com.example.demo.model.Checking;
import com.example.demo.model.Dealer;
import com.example.demo.model.VehicalWork;
import com.example.demo.repo.AddressRepo;
import com.example.demo.repo.CheckingRepo;
import com.example.demo.repo.VehicalWorkRepo;

@Service
public class CheckingService {

	@Autowired
	CheckingRepo checkingRepo;

	@Autowired
	VehicalWorkRepo partRepo;

	@Autowired
	AddressRepo addressRepo;

	public Checking getByVehical(int id) {
		return this.checkingRepo.findById(id).orElseThrow(() -> {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "vehical not found");
		});
	}

	public Checking getById(int id) {
		return this.checkingRepo.findById(id).orElseThrow(() -> {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "vehical not found");
		});
	}

	public Checking insertVehical(Checking checking) {
		return this.checkingRepo.save(checking);
	}

	public Iterable<Checking> getAllCheckingVehical() {
		return this.checkingRepo.findAll();
	}

	public Checking updateCheckOutDAte(int id, String date) {
		Checking vehicalData = getByVehical(id);
		vehicalData.setCheckOutDate(date);
		return this.checkingRepo.save(vehicalData);
	}

	public Checking updateVehical(int id, Checking checking) {
		Checking checkVehical = getByVehical(id);
		checking.setAddressCust(checkVehical.getAddressCust());
		checking.setId(id);
		checking.setCreateDate(checkVehical.getCreateDate());
		return this.checkingRepo.save(checking);
	}

	public void deleteVehical(int id) {
		Checking checkVehical = getByVehical(id);
		this.checkingRepo.deleteById(id);
	}

	// ====================Vehicle Work operation=======================

	public VehicalWork addPart(int id, VehicalWork part) {
		Checking checkVehical = getByVehical(id);
		part.setChecking(checkVehical);
		VehicalWork partData = this.partRepo.save(part);
		return partData;
	}

	public List<VehicalWork> getAllParts(int id) {
		Checking checkVehical = getByVehical(id);
		return checkVehical.getVehical_Work();
	}

	public void deleteWork(int id, int workId) {
		Checking checkVehical = getByVehical(id);

		List<VehicalWork> vehicaAlllData = checkVehical.getVehical_Work();
		VehicalWork data = null;
		for (VehicalWork vehicalWork : vehicaAlllData) {
			if (vehicalWork.getId() == workId) {
				data = vehicalWork;
			}
		}
		this.partRepo.deleteById(data.getId());
	}

	// add address
	public Address addAddress(int id, Address address) {
		Checking vehical = getByVehical(id);
		Address AddressData = this.addressRepo.save(address);
		vehical.setAddressCust(AddressData);
		this.checkingRepo.save(vehical);
		return AddressData;
	}

}
