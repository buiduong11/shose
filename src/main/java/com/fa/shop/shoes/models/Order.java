package com.fa.shop.shoes.models;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bill")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int id_bill;
	private int id_user;
	private int id_product;
	private int id_address_order;
	private double price;
	private double quantity;
	private int size;
	private int status;
	private String time;
	
	@ElementCollection(targetClass=Address_order.class)
	private List<Address_order> address = null;
	
	public Order(){}
	
	public Order(int id_bill, int id_user, int id_product, int id_address_order, double price, double quantity,
			int size, int status, String time) {
		super();
		this.id_bill = id_bill;
		this.id_user = id_user;
		this.id_product = id_product;
		this.id_address_order = id_address_order;
		this.price = price;
		this.quantity = quantity;
		this.size = size;
		this.status = status;
		this.time = time;
	}
	
	
	public int getId_bill() {
		return id_bill;
	}
	public void setId_bill(int id_bill) {
		this.id_bill = id_bill;
	}
	public int getId_user() {
		return id_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	public int getId_product() {
		return id_product;
	}
	public void setId_product(int id_product) {
		this.id_product = id_product;
	}
	public int getId_address_order() {
		return id_address_order;
	}
	public void setId_address_order(int id_address_order) {
		this.id_address_order = id_address_order;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Address_order> getAddress() {
		return address;
	}

	public void setAddress(List<Address_order> address) {
		this.address = address;
	}
	
	
	
}
