package com.fa.shop.shoes.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "size_product")
public class Sizes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int id_size_product;
	private String size;
	private double quantity;

	public Sizes() {

	}

	public Sizes(int id_size_product, String size, double quantity) {
		super();
		this.id_size_product = id_size_product;
		this.size = size;
		this.quantity = quantity;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

}
