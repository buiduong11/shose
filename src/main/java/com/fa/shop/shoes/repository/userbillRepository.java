package com.fa.shop.shoes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fa.shop.shoes.models.UserBill;

public interface userbillRepository extends JpaRepository<UserBill, Integer>{

	@Query(value = "SELECT SUM(a.price) AS price, b.first_name, b.last_name, b.email, b.phone, b.gender, b.id_user "
			+ "FROM bill AS a INNER JOIN user AS b ON a.id_user = b.id_user GROUP BY a.id_user ORDER BY price DESC", nativeQuery = true)
	List<UserBill> UserMaxBill();
}
