package com.fa.shop.shoes.services.IService;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.data.domain.Page;

import com.fa.shop.shoes.models.Order_address;

public interface IBillService {
	Page<Order_address> show(String date1, String date2, int p);
	Page<Order_address> showStatus(int status, String date1, String date2, int p);
	void exportToExcel(HttpServletResponse response,  int status, String date1, String date2);
}
