package com.fa.shop.shoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fa.shop.shoes.models.Address_order;

public interface address_orderRepository extends JpaRepository<Address_order, Integer>{

//	@Modifying
//	@Query(value = "INSERT INTO address_order (full_name, address, phone) VALUES (?1, ?2, ?3)", nativeQuery = true)
//	public void add(String fullname, String address, String phone);
	
	@Query(value = "SELECT * FROM `address_order` WHERE id_address_order = ?", nativeQuery = true)
	public Address_order showAddress(int id);
	
	
}
