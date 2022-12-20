package com.fa.shop.shoes.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "catagory")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int id_category;
	private String category;
	
	public Category() {
		
	}
	
	public Category(int id_category, String category) {
		this.id_category = id_category;
		this.category = category;
	}
	
	public int getId_category() {
		return id_category;
	}
	public void setId_category(int id_category) {
		this.id_category = id_category;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	

}
