package com.fa.shop.shoes.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Order_address {
	@Id
	private int id_bill;
	private String full_name;
	private String Address;
	private double Quantity;
	private int status;
	private double price;
	
	public Order_address() {
		
	}
	
	public Order_address(int id_bill, String full_name, String address, double quantity, int status, double price) {
		super();
		this.id_bill = id_bill;
		this.full_name = full_name;
		Address = address;
		Quantity = quantity;
		this.status = status;
		this.price = price;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getId_bill() {
		return id_bill;
	}
	public void setId_bill(int id_bill) {
		this.id_bill = id_bill;
	}
	public String getFull_name() {
		return full_name;
	}
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public double getQuantity() {
		return Quantity;
	}
	public void setQuantity(double quantity) {
		Quantity = quantity;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
	
	
	
}
