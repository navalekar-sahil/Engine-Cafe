package com.example.demo.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@NotBlank
	@NotNull
	@Size(max = 15)
	private String state;
	
	@NotBlank
	@NotNull
	@Size(max = 15)
	private String district;
	
	@NotBlank
	@NotNull
	@Size(max = 20)
	private String village;

	@JsonIgnore
	@OneToOne(mappedBy = "address1")
	private Worker worker;
	
	@JsonIgnore
	@OneToOne(mappedBy = "address")
	private Dealer dealer;
	
	@JsonIgnore
	@OneToOne(mappedBy = "addressCust")
	private Checking checking;

	public Address(int id, @NotBlank @NotNull @Size(max = 15) String state,
			@NotBlank @NotNull @Size(max = 15) String district, @NotBlank @NotNull @Size(max = 20) String village
			) {
		this.id = id;
		this.state = state;
		this.district = district;
		this.village = village;
		
	}

	public Checking getChecking() {
		return checking;
	}

	public void setChecking(Checking checking) {
		this.checking = checking;
	}

	public int getId() {
		return id;
	}

	public Dealer getDealer() {
		return dealer;
	}

	public void setDealer(Dealer dealer) {
		this.dealer = dealer;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDistrict() {
		return district;
	}

	public Worker getWorker() {
		return worker;
	}

	public void setWorker(Worker worker) {
		this.worker = worker;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getVillage() {
		return village;
	}

	public void setVillage(String village) {
		this.village = village;
	}

	

	public Address() {
	}
	
	
}
