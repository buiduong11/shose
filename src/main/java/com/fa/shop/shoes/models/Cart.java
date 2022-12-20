package com.fa.shop.shoes.models;

public class Cart {
	
	private int id;
	private int id_pro;
	private Double quantity;
	private int size;
	
	private String title;
	private String image;
	private double price;
	
	public Cart(int id, Double quantity, int size, String title, String image, double price, int id_pro) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.size = size;
		this.title = title;
		this.image = image;
		this.price = price;
		this.id_pro = id_pro;
	}
	
	
	public Cart(int id, Double quantity, int size, String title, String image, double price) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.size = size;
		this.title = title;
		this.image = image;
		this.price = price;
	}


	public Cart(int id, double quantity, int size) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.size = size;
	}

	
	public Cart(String title, String image, double price) {
		super();
		this.title = title;
		this.image = image;
		this.price = price;
	}


	public int getId_pro() {
		return id_pro;
	}


	public void setId_pro(int id_pro) {
		this.id_pro = id_pro;
	}


	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}


	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
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
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	
	

}
