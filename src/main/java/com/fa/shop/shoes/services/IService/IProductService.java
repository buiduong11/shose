package com.fa.shop.shoes.services.IService;

import com.fa.shop.shoes.models.Image;
import com.fa.shop.shoes.models.Product;
import com.fa.shop.shoes.models.Production;
import com.fa.shop.shoes.models.Size;

public interface IProductService {

	void editProduct(Image obj); 
	void editSize(Size obj);
	void editProduct(Production obj);
}
