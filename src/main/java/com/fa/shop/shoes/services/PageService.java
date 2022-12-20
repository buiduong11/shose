package com.fa.shop.shoes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fa.shop.shoes.models.Order;
import com.fa.shop.shoes.models.Order_address;
import com.fa.shop.shoes.models.Product;
import com.fa.shop.shoes.models.ProductionApi;
import com.fa.shop.shoes.repository.orderAddressRepository;
import com.fa.shop.shoes.repository.orderRepository;
import com.fa.shop.shoes.repository.productionApiRepository;
import com.fa.shop.shoes.services.IService.IPageService;

@Service
public class PageService implements IPageService{

	@Autowired
	private orderRepository orderRepo;
	
	@Autowired
	private orderAddressRepository orderAddressRepo;
	
	@Autowired
	private productionApiRepository apiRepository;
	@Override
	public Page<Order_address> pageOrderAdmin(int p) {
		Pageable pageable = PageRequest.of(p, 5);
		Page<Order_address> s = orderAddressRepo.showBill(pageable);
		return s;
	}

	@Override
	public Page<ProductionApi> pageProduct(int p) {
		Pageable pageable = PageRequest.of(p, 6);
		Page<ProductionApi> s = apiRepository.showProduct(pageable);
		return s;
	}


	
	
	
}
