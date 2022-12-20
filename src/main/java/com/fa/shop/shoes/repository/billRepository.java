package com.fa.shop.shoes.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fa.shop.shoes.models.Bill;
import com.fa.shop.shoes.models.Product;

public interface billRepository extends JpaRepository<Bill, Integer>{

	@Query(value = "SELECT a.time,a.id_bill,a.price,a.quantity,a.status, b.title_product, c.full_name "
			+ "FROM bill AS a INNER JOIN product AS b ON a.id_product = b.id_product "
			+ "INNER JOIN address_order AS c ON a.id_address_order = c.id_address_order", nativeQuery = true)
	List<Bill> showBill();
	
	@Query(value = "DELETE FROM bill WHERE id_bill = ?", nativeQuery = true)
	void deleteBill(int id_bill);
	
	
	@Query(value = "SELECT COUNT(DISTINCT id_bill) FROM bill", nativeQuery = true)
	int countBill();
	
	@Query(value = "SELECT SUM(quantity) AS quantity , id_bill, SUM(price * quantity) AS price, status, time "
			+ "FROM `bill` WHERE id_user = ? GROUP BY id_bill", nativeQuery = true)
	List<Bill> shoewBillUser(int id_user);
	
	@Query(value = "SELECT SUM(quantity) AS quantity , id_bill, SUM(price * quantity) AS price, status, time "
			+ "FROM `bill` GROUP BY id_bill", nativeQuery = true)
	List<Bill> shoewBillUser();
	
	@Query(value = "SELECT SUM(quantity) AS quantity , id_bill, SUM(price * quantity) AS price, status, time FROM `bill` WHERE time BETWEEN ?1 AND ?2  GROUP BY id_bill", nativeQuery = true)
	List<Bill> showBillAdmin(String date1, String date2);

	@Query(value = "SELECT SUM(quantity) AS quantity , id_bill, SUM(price * quantity) AS price, status, time FROM `bill` WHERE status = ?1 AND time BETWEEN ?2 AND ?3 GROUP BY id_bill", nativeQuery = true)
	void showStatus(int status, String date1, String date2);

	
}
