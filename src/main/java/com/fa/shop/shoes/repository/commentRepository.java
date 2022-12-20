package com.fa.shop.shoes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fa.shop.shoes.models.Comment;


public interface commentRepository extends JpaRepository<Comment, Integer>{

	@Query(value = "SELECT a.id_comment, b.first_name, b.last_name, c.content, a.time FROM comment AS a INNER JOIN user AS b ON a.id_user = b.id_user INNER JOIN review AS c ON a.id_review = c.id_review WHERE a.id_product = ?", nativeQuery = true)
	List<Comment> showCommentUserProduct(int id_product);
	
}
