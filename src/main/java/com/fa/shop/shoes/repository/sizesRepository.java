package com.fa.shop.shoes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.fa.shop.shoes.models.Sizes;

public interface sizesRepository extends JpaRepository<Sizes, Integer>{
	
	@Query(value = "SELECT * FROM size_product WHERE id_size_product = ? AND quantity > 0", nativeQuery = true)
	List<Sizes> showSizeProduct(int id_size_product);

	@Transactional
	@Modifying
	@Query(value = "UPDATE size_product SET size = ?2, quantity = ?3 WHERE id = ?1", nativeQuery = true)
	int updateSizeProduct(int id, String size, double quantity);
	
	
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM size_product WHERE id = ?1", nativeQuery = true)
	int deleteSizeProduct(int id);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE size_product SET quantity = ?1 WHERE id = ?2", nativeQuery = true)
	int updateSizeQuantity(double quantity, int id);
	
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE `size_product` SET quantity = quantity + ?1 WHERE id_size_product = ?3 AND id = ?2", nativeQuery = true)
	int updateQuantity(double quantity, String size, int id);	
}
