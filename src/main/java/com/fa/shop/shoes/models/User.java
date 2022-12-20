package com.fa.shop.shoes.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "User")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_user")
	private int id_user;
	@Column(name = "first_name")
	private String first_name;
	@Column(name = "last_name")
	private String last_name;
	@Column(name = "email")
	private String email;
	@Column(name = "phone")
	private String phone = "";
	@Column(name = "gender")
	private String gender = "";
	@Column(name = "password")
	private String password;
	@Column(name = "address")
	private String address = "";
	@Column(name = "role")
	private int role;
	
	public User() {}

	public User(String first_name, String last_name, String email, String password, int role, String phone) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.password = password;
		this.role = role;
		this.phone = phone;
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}
	
	
	
	
}
