package com.fa.shop.shoes.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fa.shop.shoes.models.Cart;
import com.fa.shop.shoes.models.CartApi;
import com.fa.shop.shoes.services.IService.ICheckOutService;

@RestController
public class CheckOutController {

	private ICheckOutService checkOutService;
	public CheckOutController(ICheckOutService checkOutService) {
		this.checkOutService = checkOutService;
	}
	
	@PostMapping("/checkcart")
	public CartApi checkout(HttpSession session){
		return checkOutService.checkout(session);
	}
	
	@PostMapping("/checkStatus")
	public int checkStatus(@RequestParam int id, @RequestParam int status){
		return checkOutService.checkStatus(id, status);
	}
	
}
