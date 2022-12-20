package com.fa.shop.shoes.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "comment")
public class ReviewComment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_comment;
	private int id_user;
	private int id_product;
	private int id_review;
	private int id_recomment;
	private String time;
	
	
	public ReviewComment(int id_user, int id_product, int id_review,String time) {
		super();
		this.id_user = id_user;
		this.id_product = id_product;
		this.id_review = id_review;
		this.id_recomment = id_recomment;
		this.time = time;
	}
	
	public int getId_comment() {
		return id_comment;
	}
	public void setId_comment(int id_comment) {
		this.id_comment = id_comment;
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
	public int getId_review() {
		return id_review;
	}
	public void setId_review(int id_review) {
		this.id_review = id_review;
	}
	public int getId_recomment() {
		return id_recomment;
	}
	public void setId_recomment(int id_recomment) {
		this.id_recomment = id_recomment;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	
}
