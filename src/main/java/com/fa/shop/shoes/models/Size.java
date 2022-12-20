package com.fa.shop.shoes.models;

public class Size {
	private int id;
	private int id_size_product;
	private String size;
	private double quantity;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_size_product() {
		return id_size_product;
	}
	public void setId_size_product(int id_size_product) {
		this.id_size_product = id_size_product;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	
}
