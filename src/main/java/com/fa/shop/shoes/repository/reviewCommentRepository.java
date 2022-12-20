package com.fa.shop.shoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fa.shop.shoes.models.ReviewComment;

public interface reviewCommentRepository extends JpaRepository<ReviewComment, Integer>{
	@Query(value = "DELETE FROM review WHERE id = ?", nativeQuery = true)
	void deleteImageProduct(int id_image_product);
}
