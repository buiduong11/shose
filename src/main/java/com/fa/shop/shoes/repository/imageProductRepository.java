package com.fa.shop.shoes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.fa.shop.shoes.models.ImageProduct;

public interface imageProductRepository extends JpaRepository<ImageProduct, Integer>{
	@Query(value = "SELECT * FROM image_product WHERE id_image_product = ?", nativeQuery = true)
	List<ImageProduct> showImageProductAll(int id_image_product);
	
//	@Query(value = "DELETE FROM image_product WHERE id_image_product = ?", nativeQuery = true)
//	void deleteImageProduct(int id_image_product);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE image_product SET image = ?2 WHERE id_image = ?1", nativeQuery = true)
	int updateImageProduct(int id, String image);
	
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM image_product WHERE id_image_product = ?1", nativeQuery = true)
	int deleteImageProduct(int id);
}
