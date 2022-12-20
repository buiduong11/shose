package com.fa.shop.shoes.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class ImageProduct {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_image;
	private int id_image_product;
	private String image;
	
	public ImageProduct(){
		
	}
	
	public int getId_image() {
		return id_image;
	}

	public void setId_image(int id_image) {
		this.id_image = id_image;
	}

	public ImageProduct(int id_image_product, String image) {
		super();
		this.id_image_product = id_image_product;
		this.image = image;
	}
	public int getId_image_product() {
		return id_image_product;
	}
	public void setId_image_product(int id_image_product) {
		this.id_image_product = id_image_product;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	
}
