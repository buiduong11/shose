package com.fa.shop.shoes.models;

import java.util.List;

public class CartApi {

	private int status;
	private String message;
	private List<Cart> data;
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public List<Cart> getData() {
		return data;
	}
	public void setData(List<Cart> data) {
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	
	
}
