package com.fa.shop.shoes.controllers;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fa.shop.shoes.models.Image;
import com.fa.shop.shoes.models.Product;
import com.fa.shop.shoes.models.Production;
import com.fa.shop.shoes.models.Size;
import com.fa.shop.shoes.services.IService.IProductService;

@RestController
public class ProductController {

	private IProductService iProductService;
	
	public ProductController(IProductService iProductService){
		this.iProductService = iProductService;
	}
	
	@PostMapping("/editImage")
	public void editImage(@ModelAttribute Image obj){
		 iProductService.editProduct(obj);
	}
	
	@PostMapping("/editSize")
	public void editSize(@ModelAttribute Size obj){
		 iProductService.editSize(obj);
	}
	
	@PostMapping("/editProduct")
	public void editProduct(@ModelAttribute Production obj){
		 iProductService.editProduct(obj);
	}
}
