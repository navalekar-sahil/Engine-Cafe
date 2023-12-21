package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.model.Address;
import com.example.demo.model.Checking;
import com.example.demo.model.Dealer;
import com.example.demo.model.Worker;
import com.example.demo.repo.AddressRepo;
import com.example.demo.repo.WorkerRepo;

@Service
public class WorkerService {

	@Autowired
	WorkerRepo workerRepo;

	@Autowired
	AddressRepo addressRepo;
	
	public Worker getByWorker(int id) {
		return this.workerRepo.findById(id).orElseThrow(() -> {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Worker not found");
		});
	}
	public Worker getByWorkerById(int id) {
		return this.workerRepo.findById(id).orElseThrow(() -> {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Worker not found");
		});
	}
	public Iterable<Worker> getAllWorker() {
		return this.workerRepo.findAll();
	}

	
	public Worker createWorker(Worker worker) {
		return this.workerRepo.save(worker);
	}
	
	public Worker updateWorker(int id ,Worker worker) {
		Worker  workerData=getByWorker(id);
		worker.setId(id);
//		worker.setCreateDate(workerData.getCreateDate());
		worker.setAddress(workerData.getAddress());
		return this.workerRepo.save(worker);
	}
	
	
//	public EmployeeModel update(int id, EmployeeModel employeeModel) {
//		EmployeeModel empData = getEmployeeWithDetails(id);
//		employeeModel.setId(id);
//		employeeModel.setCreateDate(empData.getCreateDate());
//		return this.employeeRepo.save(employeeModel);
//	}
	
	
	
	
	public void deleteWorker(int id) {
		Worker  workerData=getByWorker(id);
		this.workerRepo.deleteById(id);
	}
	//========================Worker Address==================
	
	public Address addAddress(int id,Address  address) {
		Worker  workerData= getByWorker(id);
		address.setId(id);
		Address AddressData=this.addressRepo.save(address);
		workerData.setAddress(AddressData);
		this.workerRepo.save(workerData);
		return AddressData;
	}
	
	
}
