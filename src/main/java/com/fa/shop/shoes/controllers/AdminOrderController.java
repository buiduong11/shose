package com.fa.shop.shoes.controllers;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fa.shop.shoes.models.Address_order;
import com.fa.shop.shoes.models.Bill;
import com.fa.shop.shoes.models.ImageProduct;
import com.fa.shop.shoes.models.Order;
import com.fa.shop.shoes.models.Order_address;
import com.fa.shop.shoes.models.Product;
import com.fa.shop.shoes.models.Review;
import com.fa.shop.shoes.repository.address_orderRepository;
import com.fa.shop.shoes.repository.billRepository;
import com.fa.shop.shoes.repository.orderRepository;
import com.fa.shop.shoes.repository.productRepository;

@Controller
public class AdminOrderController {

	@Autowired
	private orderRepository orderRepo;
	
	@Autowired
	private productRepository productRepo;
	
	@Autowired
	private address_orderRepository address_orderRepo;
	
	@RequestMapping(value = { "admin/order" }, method =  RequestMethod.GET)
    public String order(HttpServletRequest request, Model model) {
		
		if(request.getCookies() != null) {
			for (Cookie c : request.getCookies()) {
	            if (c.getName().equals("idAdmin"))
	            {
//	            	List<Order> list = orderRepo.shoewBillUser();
//	        		List<Address_order> listAddressOrder = address_orderRepo.findAll();
	        		String pattern = "yyyy-MM-dd";
	        		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
	        		String date = simpleDateFormat.format(new Date());
	        		model.addAttribute("date", date);
//	        		model.addAttribute("bill", list);
//	        		model.addAttribute("address_order", listAddressOrder);
	                return "admin/order";
	            }
			}
    	}
    	
        return "redirect:/admin/login";
	
    }
	
//	@RequestMapping(value = { "order/page" }, method =  RequestMethod.GET)
//    public String orderPage(HttpServletRequest request, Model model, @RequestParam("p") Optional<Integer> p) {
//		
//		Pageable pageable = PageRequest.of(1, 5);
//		Page<Order> s = orderRepo.findAll(pageable);
//		System.out.println("asdasd "+s.getContent() );
//    	
//        return "redirect:/admin/login";
//	
//    }
	

	@RequestMapping(value = { "/admin/delete_order" }, method =  RequestMethod.GET)
    public String delete_product(@RequestParam int id, HttpServletRequest request, Model model) {
		if(request.getCookies() != null) {
			for (Cookie c : request.getCookies()) {
	            if (c.getName().equals("idAdmin"))
	            {
	            	orderRepo.deleteBill(id);
	            	
	                return "redirect:/admin/order";
	            }
			}
    	}
    	
        return "redirect:/admin/login";
	
    }

}
