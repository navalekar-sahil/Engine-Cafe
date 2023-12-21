package com.example.demo.model;

import java.time.Instant;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
//@EntityListeners(AuditingEntityListener.class)

public class Worker {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String name;
	private String email;
	private String mobile;
	
//	@CreatedDate
//	private Instant createDate;
//
//	@LastModifiedDate
//	private Instant updateDate;

	@OneToOne
	@JoinColumn(name = "address_id")
	private Address address1;

	

	public Worker(int id, String name, String email, String mobile) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
	}

	public Worker() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

//	public Instant getCreateDate() {
//		return createDate;
//	}
//
//	public void setCreateDate(Instant createDate) {
//		this.createDate = createDate;
//	}
//
//	public Instant getUpdateDate() {
//		return updateDate;
//	}
//
//	public void setUpdateDate(Instant updateDate) {
//		this.updateDate = updateDate;
//	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Address getAddress() {
		return address1;
	}

	public void setAddress(Address address) {
		this.address1 = address;
	}

}
