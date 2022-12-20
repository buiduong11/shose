package com.fa.shop.shoes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.fa.shop.shoes.models.Bill;
import com.fa.shop.shoes.models.Order;

public interface orderRepository extends JpaRepository<Order, Integer>{

	@Query(value = "SELECT * FROM bill WHERE id_user = ?", nativeQuery = true)
	List<Order> showOrder(int id_user);
	
	@Query(value = "SELECT * FROM bill WHERE id_bill = ?", nativeQuery = true)
	List<Order> show(int id_bill);
	
	@Query(value = "SELECT SUM(quantity) AS quantity, id_product, "
			+ "id, id_user , id_bill, SUM(price * quantity) AS price, status, "
			+ "id_address_order, time, size "
			+ "FROM `bill` GROUP BY id_bill", nativeQuery = true)
	List<Order> shoewBillUser();
	
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM bill WHERE id_bill = ?", nativeQuery = true)
	int deleteBill(int id_bill);
	
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM bill WHERE id = ?", nativeQuery = true)
	int deleteBillProduct(int id);
	
	
	@Query(value = "SELECT SUM(quantity) AS quantity, id_product, "
			+ "id, id_user , id_bill, SUM(price * quantity) AS price, status, "
			+ "id_address_order, time, size "
			+ "FROM `bill` WHERE time BETWEEN ?1 AND ?2  GROUP BY id_bill", nativeQuery = true)
	List<Order> showBillAdmin(String date1, String date2);

	@Query(value = "SELECT SUM(quantity) AS quantity, id_product, "
			+ "id, id_user , id_bill, SUM(price * quantity) AS price, status, "
			+ "id_address_order, time, size "
			+ "FROM `bill` WHERE status = ?1 AND time BETWEEN ?2 AND ?3 GROUP BY id_bill", nativeQuery = true)
	List<Order> showStatus(int status, String date1, String date2);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE bill SET status = ?2 WHERE id_bill = ?1", nativeQuery = true)
	int updateBillStatus(int id_bill, int status);
	
	
	
}
