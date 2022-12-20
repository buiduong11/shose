package com.fa.shop.shoes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fa.shop.shoes.models.Review;

public interface reviewRepository extends JpaRepository<Review, Integer>{
	
	
}
