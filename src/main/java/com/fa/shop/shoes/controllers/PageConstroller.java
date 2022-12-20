package com.fa.shop.shoes.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fa.shop.shoes.models.Order;
import com.fa.shop.shoes.models.Order_address;
import com.fa.shop.shoes.models.ProductionApi;
import com.fa.shop.shoes.services.IService.IPageService;

@RestController
public class PageConstroller {

	private IPageService iPageService;
	public PageConstroller(IPageService iPageService) {
		this.iPageService = iPageService;
	}
	
	@PostMapping("/order/page")
	Page<Order_address> PageOrderAdmin(@RequestParam("p") int p){
		return iPageService.pageOrderAdmin(p);
	}
	

	@PostMapping("/product/page")
	Page<ProductionApi> PageProduct(@RequestParam("p") int p){
		return iPageService.pageProduct(p);
	}
	
}
