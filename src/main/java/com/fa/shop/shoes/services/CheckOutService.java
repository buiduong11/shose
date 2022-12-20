package com.fa.shop.shoes.services;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fa.shop.shoes.models.Cart;
import com.fa.shop.shoes.models.CartApi;
import com.fa.shop.shoes.models.Order;
import com.fa.shop.shoes.models.Sizes;
import com.fa.shop.shoes.repository.orderRepository;
import com.fa.shop.shoes.repository.productRepository;
import com.fa.shop.shoes.repository.sizesRepository;
import com.fa.shop.shoes.services.IService.ICheckOutService;

@Service
public class CheckOutService implements ICheckOutService{

	
	@Autowired
	private sizesRepository sizesRepo;
	
	@Autowired
	private orderRepository orderRepo;
	
	@Autowired
	private sizesRepository sizeRepo;
	
	@Override
	public CartApi checkout(HttpSession session) {
		List<Cart> messages = new ArrayList<>();
    	List<Cart> thieeus = new ArrayList<>();
		messages = (List<Cart>) session.getAttribute("MY_SESSION_MESSAGES");
		List<Sizes> sizes = sizesRepo.findAll();
		CartApi obj = new CartApi();
		if(messages != null) {
			if(messages.size() > 0) {
				for (Cart list : messages) {
					for (Sizes size : sizes) {
						if(list.getId() == size.getId_size_product() && list.getSize() == size.getId()) {
							double quantity = (size.getQuantity() - list.getQuantity());
							if(quantity <= 0) {
								thieeus.add(list);
								obj.setStatus(2);
								obj.setMessage("san pham vuoc qua muc");
								obj.setData(thieeus);
							}
						}		
					}
				}
			}else {
				obj.setStatus(1);
				obj.setMessage("gio hang rong");
				obj.setData(messages);
			}
		}
		else {
			obj.setStatus(1);
			obj.setMessage("gio hang rong");
			obj.setData(messages);
		}
		return obj;
	}

	@Override
	public int checkStatus(int id , int status) {
		orderRepo.updateBillStatus(id, status);
		if(status == 2) {
			System.out.print("HIHI " + id);
			List<Order> list = orderRepo.show(id);
			for (Order order : list) {
				System.out.println("HIHI " + order.getId_product());
				sizeRepo.updateQuantity(order.getQuantity(), String.valueOf(order.getSize()),order.getId_product() );
			}
		}
		return 0;
	}

}
