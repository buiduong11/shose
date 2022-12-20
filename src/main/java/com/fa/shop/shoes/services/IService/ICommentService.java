package com.fa.shop.shoes.services.IService;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.fa.shop.shoes.models.Review;

public interface ICommentService {
	
	List<Review> addRecomment(int id,String review);
	
}
