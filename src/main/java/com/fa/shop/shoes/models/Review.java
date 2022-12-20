package com.fa.shop.shoes.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Review")
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_review;
	private String title_review;
	private String content;
	
	public Review() {}
	public Review(String title_review, String content) {
		super();
		this.title_review = title_review;
		this.content = content;
	}
	
	public int getId_review() {
		return id_review;
	}
	public void setId_review(int id_review) {
		this.id_review = id_review;
	}
	public String getTitle_review() {
		return title_review;
	}
	public void setTitle_review(String title_review) {
		this.title_review = title_review;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
