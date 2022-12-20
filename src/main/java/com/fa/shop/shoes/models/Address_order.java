package com.fa.shop.shoes.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.micrometer.core.annotation.Counted;

@Entity
@Table(name = "address_order")
public class Address_order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_address_order;
	@Column(name = "full_name")
	private String full_name;
	@Column(name = "address")
	private String address;
	@Column(name = "phone")
	private String phone;
	
	
	public Address_order() {}
	
	public Address_order(String full_name, String address, String phone) {
		super();
		this.full_name = full_name;
		this.address = address;
		this.phone = phone;
	}
	
	public int getId_address_order() {
		return id_address_order;
	}
	public void setId_address_order(int id_address_order) {
		this.id_address_order = id_address_order;
	}
	public String getFull_name() {
		return full_name;
	}
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
	
}
