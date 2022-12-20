package com.fa.shop.shoes.controllers;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fa.shop.shoes.config.UserExcelExporter;
import com.fa.shop.shoes.models.Order_address;
import com.fa.shop.shoes.services.IService.IBillService;

@RestController
public class BillController {
	private IBillService billService;
	public BillController(IBillService billService) {
		this.billService = billService;
	}
	
	@PostMapping("/seachorder")
	public Page<Order_address> show(@RequestParam String date1, @RequestParam String date2, @RequestParam int p){
		return billService.show(date1, date2, p);
	}
	
	@PostMapping("/searchStaus")
	public Page<Order_address> showStatus(@RequestParam int status,@RequestParam String date1, @RequestParam String date2, @RequestParam int p){
		return billService.showStatus(status , date1,  date2, p);
	}
	
	@GetMapping("/admin/export/excel")
    public void exportToExcel(HttpServletResponse response, int status, @RequestParam String date1, @RequestParam String date2) throws IOException {
		billService.exportToExcel(response, status, date1, date2);
    }  
}
