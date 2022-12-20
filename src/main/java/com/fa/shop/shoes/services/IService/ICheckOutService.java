package com.fa.shop.shoes.services.IService;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.fa.shop.shoes.models.Cart;
import com.fa.shop.shoes.models.CartApi;

public interface ICheckOutService {
	CartApi checkout(HttpSession session);
	int checkStatus(int id, int status);
}
