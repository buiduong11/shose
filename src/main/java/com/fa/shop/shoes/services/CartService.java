package com.fa.shop.shoes.services;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fa.shop.shoes.models.Address_order;
import com.fa.shop.shoes.models.Cart;
import com.fa.shop.shoes.models.ImageProduct;
import com.fa.shop.shoes.models.Order;
import com.fa.shop.shoes.models.Product;
import com.fa.shop.shoes.repository.address_orderRepository;
import com.fa.shop.shoes.repository.imageProductRepository;
import com.fa.shop.shoes.repository.orderRepository;
import com.fa.shop.shoes.repository.productRepository;
import com.fa.shop.shoes.services.IService.ICartService;

@Service
public class CartService implements ICartService{

	@Autowired
	private productRepository productRepo;
	
	@Autowired
	private imageProductRepository imageProductRepo;
	
	@Autowired
	private orderRepository orderRepo;
	
	@Autowired
	private address_orderRepository address_orderRepo;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Cart> removeCart(int id, HttpSession session) {
		
		List<Cart> messages = new ArrayList<>();
		messages = (List<Cart>) session.getAttribute("MY_SESSION_MESSAGES");
		if(messages != null) {
			System.out.print(messages.size());
			System.out.print("BABA "+id);
			for (Cart list : messages) {
				if(list.getId() == id) {
					messages.remove(list);
					break;
				}
			}
			
			if(messages != null) {
				session.setAttribute("MY_SESSION_MESSAGES", messages);
				messages = (List<Cart>) session.getAttribute("MY_SESSION_MESSAGES");
				System.out.print(messages.size());
				for (Cart list : messages) {
					System.out.print("thuong"+list.getId());
					Product listProduct = productRepo.showProduct(list.getId());
			    	List<ImageProduct> list_image = imageProductRepo.showImageProductAll(list.getId());
			    	list.setTitle(listProduct.getTitle_product());
			    	list.setPrice(listProduct.getPrice());
			    	list.setImage(list_image.get(0).getImage());
				}
				return messages;
			}
		}
		
        return null;
	}

	@Override
	public List<Cart> adminremoveCart(int id, int id_bill) {
		
		orderRepo.deleteBillProduct(id);
    	
		List<Order> listorder = orderRepo.show(id_bill);
		List<Cart> messages = new ArrayList<>();
		
//		if(messages != null) {
//			System.out.print(messages.size());
			
			for(int i = 0 ; i < listorder.size() ; i++) {
				Product listProduct = productRepo.showProduct(listorder.get(i).getId_product());
		    	List<ImageProduct> list_image = imageProductRepo.showImageProductAll(listorder.get(i).getId_product());
		    	messages.add(new Cart(listorder.get(i).getId_bill(), listorder.get(i).getQuantity(), 
		    			listorder.get(i).getSize(), listProduct.getTitle_product(), list_image.get(0).getImage(), 
		    			listProduct.getPrice(), listorder.get(i).getId()));
			}
			
	
        return messages;
	}

}
