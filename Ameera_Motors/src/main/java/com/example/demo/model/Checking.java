package com.example.demo.model;

import java.time.Instant;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Checking {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@NotNull
	@NotBlank
	@Size(min = 3, max = 25)
	private String ownerName;

	@NotNull
	@NotBlank
	@Size(min = 10)
	private String mobile;

	@NotNull
	@NotBlank
	private String vehicalModel;

	@NotBlank
	@NotNull
	private String vehicalNumber;

//	private String vehicalWork;

	private String checkInDate;

	private String CheckOutDate;

	@CreatedDate
	private Instant createDate;
	@LastModifiedDate
	private Instant updateDate;

	@OneToMany(mappedBy = "checking")
	private List<VehicalWork> vehical_Work;

	@OneToOne()
	@JoinColumn(name = "VehicalCust_id")
	private Address addressCust;

	public Checking(int id, @NotNull @NotBlank @Size(min = 3, max = 25) String ownerName,
			@NotNull @NotBlank @Size(min = 10) String mobile, @NotNull @NotBlank String vehicalModel,
			@NotBlank @NotNull String vehicalNumber, String checkInDate, String checkOutDate) {
		super();
		this.id = id;
		this.ownerName = ownerName;
		this.mobile = mobile;
		this.vehicalModel = vehicalModel;
		this.vehicalNumber = vehicalNumber;
		this.checkInDate = checkInDate;
		CheckOutDate = checkOutDate;
	}

	public Address getAddressCust() {
		return addressCust;
	}

	public void setAddressCust(Address addressCust) {
		this.addressCust = addressCust;
	}

	public List<VehicalWork> getVehical_Work() {
		return vehical_Work;
	}

	public void setVehical_Work(List<VehicalWork> vehical_Work) {
		this.vehical_Work = vehical_Work;
	}

//	public void setVehicalWork(String vehicalWork) {
//		this.vehicalWork = vehicalWork;
//	}

	public Checking() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public Instant getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Instant createDate) {
		this.createDate = createDate;
	}

	public Instant getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Instant updateDate) {
		this.updateDate = updateDate;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getVehicalModel() {
		return vehicalModel;
	}

	public void setVehicalModel(String vehicalModel) {
		this.vehicalModel = vehicalModel;
	}

	public String getVehicalNumber() {
		return vehicalNumber;
	}

	public void setVehicalNumber(String vehicalNumber) {
		this.vehicalNumber = vehicalNumber;
	}

	public String getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(String checkInDate) {
		this.checkInDate = checkInDate;
	}

	public String getCheckOutDate() {
		return CheckOutDate;
	}

	public void setCheckOutDate(String checkOutDate) {
		CheckOutDate = checkOutDate;
	}

}
