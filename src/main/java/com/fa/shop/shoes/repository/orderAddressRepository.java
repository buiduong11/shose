package com.fa.shop.shoes.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fa.shop.shoes.models.Order;
import com.fa.shop.shoes.models.Order_address;

public interface orderAddressRepository extends JpaRepository<Order_address, Integer> {
	
	@Query(value = "SELECT id_bill, full_name, address, status, SUM(a.quantity) AS quantity, SUM(a.price * a.quantity) AS price FROM bill AS a INNER JOIN address_order AS b ON a.id_address_order = b.id_address_order GROUP BY id_bill ORDER BY id"
			,countQuery = "SELECT SUM(a.quantity) AS quantity, SUM(a.price * a.quantity) AS price FROM bill AS a INNER JOIN address_order AS b ON a.id_address_order = b.id_address_order GROUP BY id_bill", nativeQuery = true)
	public Page<Order_address> showBill(Pageable pageable);
	
	@Query(value = "SELECT id_bill, full_name, address, status, SUM(a.quantity) AS quantity, SUM(a.price * a.quantity) AS price FROM bill AS a INNER JOIN address_order AS b ON a.id_address_order = b.id_address_order WHERE time BETWEEN ?1 AND ?2 GROUP BY id_bill ORDER BY id",
			countQuery = "SELECT id_bill, full_name, address, status, SUM(a.quantity) AS quantity, SUM(a.price * a.quantity) AS price FROM bill AS a INNER JOIN address_order AS b ON a.id_address_order = b.id_address_order WHERE time BETWEEN ?1 AND ?2 GROUP BY id_bill"
			,nativeQuery = true)
	Page<Order_address> showBillAdmin(String date1, String date2, Pageable pageable);
	
	@Query(value = "SELECT id_bill, full_name, address, status, SUM(a.quantity) AS quantity, SUM(a.price * a.quantity) AS price FROM bill AS a INNER JOIN address_order AS b ON a.id_address_order = b.id_address_order WHERE status = ?1 AND time BETWEEN ?1 AND ?2 GROUP BY id_bill ORDER BY id",
			countQuery = "SELECT id_bill, full_name, address, status, SUM(a.quantity) AS quantity, SUM(a.price * a.quantity) AS price FROM bill AS a INNER JOIN address_order AS b ON a.id_address_order = b.id_address_order WHERE status = ?1 AND time BETWEEN ?1 AND ?2 GROUP BY id_bill"
			, nativeQuery = true)
	Page<Order_address> showStatus(int status, String date1, String date2, Pageable pageable);
	
	@Query(value = "SELECT id_bill, full_name, address, status, SUM(a.quantity) AS quantity, SUM(a.price * a.quantity) AS price FROM bill AS a INNER JOIN address_order AS b ON a.id_address_order = b.id_address_order WHERE status = ?1 AND time BETWEEN ?1 AND ?2 GROUP BY id_bill ", nativeQuery = true)
	List<Order_address> exportStatus(int status, String date1, String date2);
	
	@Query(value = "SELECT id_bill, full_name, address, status, SUM(a.quantity) AS quantity, SUM(a.price * a.quantity) AS price FROM bill AS a INNER JOIN address_order AS b ON a.id_address_order = b.id_address_order WHERE time BETWEEN ?1 AND ?2 GROUP BY id_bill ", nativeQuery = true)
	List<Order_address> exportAll(String date1, String date2);

}
