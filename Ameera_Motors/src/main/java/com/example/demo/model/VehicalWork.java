package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class VehicalWork {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@NotNull
	@NotBlank
	private String partName;
	
	private String vehical_Work;

//	private String outWardDate;
//
//	private String inWardDate;

	@ManyToOne
	@JoinColumn(name = "Vehical_Id")
	@JsonIgnore
	private Checking checking;



	public VehicalWork(int id, @NotNull @NotBlank String partName, String vehical_Work,Checking checking) {
		super();
		this.id = id;
		this.partName = partName;
		this.vehical_Work = vehical_Work;
		
		this.checking = checking;
	}

	public String getVehical_Work() {
		return vehical_Work;
	}

	public void setVehical_Work(String vehical_Work) {
		this.vehical_Work = vehical_Work;
	}

	public VehicalWork() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPartName() {
		return partName;
	}

	public void setPartName(String partName) {
		this.partName = partName;
	}

	public Checking getChecking() {
		return checking;
	}

	public void setChecking(Checking checking) {
		this.checking = checking;
	}

}
