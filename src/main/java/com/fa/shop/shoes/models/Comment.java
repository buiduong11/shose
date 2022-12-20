package com.fa.shop.shoes.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Comment {

	@Id
	private int id_comment;
	private String first_name;
	private String last_name;
	private String content;
	private String time;
	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getId_comment() {
		return id_comment;
	}
	public void setId_comment(int id_comment) {
		this.id_comment = id_comment;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
