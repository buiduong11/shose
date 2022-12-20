package com.fa.shop.shoes.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProductionApi{
	
	@Id
	private int id_product;
	private String title_product;
	private String description;
	private double price;
	private int quantity;
	private String image;
	
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getId_product() {
		return id_product;
	}
	public void setId_product(int id_product) {
		this.id_product = id_product;
	}
	public String getTitle_product() {
		return title_product;
	}
	public void setTitle_product(String title_product) {
		this.title_product = title_product;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}
