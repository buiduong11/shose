package com.fa.shop.shoes.services.IService;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.fa.shop.shoes.models.Order_address;
import com.fa.shop.shoes.models.Product;
import com.fa.shop.shoes.models.ProductionApi;

public interface IPageService {

	Page<Order_address> pageOrderAdmin(int p);
	Page<ProductionApi> pageProduct(int p);
}
