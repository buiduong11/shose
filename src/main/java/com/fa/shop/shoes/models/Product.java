package com.fa.shop.shoes.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_product")
	private int id_product;
	@Column(name = "title_product")
	private String title_product;
	@Column(name = "description")
	private String description;
	@Column(name = "price")
	private double price;
	@Column(name = "quantity")
	private double quantity;
	@ElementCollection(targetClass=Sizes.class)
	private List<Sizes> sizes = null;
	@ElementCollection(targetClass=Category.class)
	private List<Category> category = null;
	@ElementCollection(targetClass=ImageProduct.class)
	private List<ImageProduct> images = null;
	@ElementCollection(targetClass=Comment.class)
	private List<Comment> comment = null;
	
	public Product() {
		
	}
	
	public Product(int id_product, String title_product, String description, double price, List<Sizes> sizes, List<Category> category, List<ImageProduct> images) {
		this.id_product = id_product;
		this.description = description;
		this.price = price;
		this.sizes = sizes;
		this.category = category;
		this.images = images;
		this.title_product = title_product;
	}
	
	public Product(String description, double price, String title_product) {
		this.description = description;
		this.price = price;
		this.title_product = title_product;
	}
	public List<Comment> getComment() {
		return comment;
	}
	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}
	public List<ImageProduct> getImages() {
		return images;
	}
	public void setImages(List<ImageProduct> images) {
		this.images = images;
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
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	public List<Sizes> getSizes() {
		return sizes;
	}
	public void setSizes(List<Sizes> sizes) {
		this.sizes = sizes;
	}
	public List<Category> getCategory() {
		return category;
	}
	public void setCategory(List<Category> category) {
		this.category = category;
	}
	

	
}
