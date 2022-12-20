package com.fa.shop.shoes.services.IService;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.fa.shop.shoes.models.Cart;
import com.fa.shop.shoes.models.Order;


public interface ICartService {

	List<Cart> removeCart(int id, HttpSession session);
	
	List<Cart> adminremoveCart(int id, int id_bill);
}
