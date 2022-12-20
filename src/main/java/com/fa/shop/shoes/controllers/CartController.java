package com.fa.shop.shoes.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fa.shop.shoes.models.Cart;
import com.fa.shop.shoes.models.ImageProduct;
import com.fa.shop.shoes.models.Order;
import com.fa.shop.shoes.models.Product;
import com.fa.shop.shoes.services.CartService;
import com.fa.shop.shoes.services.IService.ICartService;

@RestController
public class CartController {
	
	private ICartService IcartService;
	public CartController(ICartService IcartService) {
		this.IcartService = IcartService;
	}
	
	@SuppressWarnings("unchecked")
	@PostMapping("/cart/remove")
    public List<Cart> cartRemove(@RequestParam int id ,HttpSession session) {
        return IcartService.removeCart(id, session);
    }
	
	@SuppressWarnings("unchecked")
	@PostMapping("/admin/cart/remove")
    public List<Cart> admincartRemove(@RequestParam int id, @RequestParam int id_bill) {
        return IcartService.adminremoveCart(id,id_bill);
    }
	
	
}
