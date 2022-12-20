package com.fa.shop.shoes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.fa.shop.shoes.models.Category;

public interface catagoryRepository extends JpaRepository<Category, Integer>{

	@Query(value = "SELECT * FROM catagory WHERE id_category = ?", nativeQuery = true)
	List<Category> showCategoryProduct(int id_category);

	@Transactional
	@Modifying
	@Query(value = "UPDATE catagory SET category = ?2 WHERE id_category = ?1", nativeQuery = true)
	int updateCategoty(int id, String category);
	
}
