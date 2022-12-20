package com.fa.shop.shoes.services;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fa.shop.shoes.config.UserExcelExporter;
import com.fa.shop.shoes.models.Address_order;
import com.fa.shop.shoes.models.Order;
import com.fa.shop.shoes.models.Order_address;
import com.fa.shop.shoes.repository.address_orderRepository;
import com.fa.shop.shoes.repository.billRepository;
import com.fa.shop.shoes.repository.orderAddressRepository;
import com.fa.shop.shoes.repository.orderRepository;
import com.fa.shop.shoes.services.IService.IBillService;

@Service
public class BillService implements IBillService{
	
	@Autowired
	private orderAddressRepository addressRepo;

	@Override
	public Page<Order_address> show(String date1, String date2, int p) {
		Pageable pageable = PageRequest.of(p, 5);
		Page<Order_address> s = addressRepo.showBillAdmin(date1, date2, pageable);
		return s;
	}

	@Override
	public Page<Order_address> showStatus(int status, String date1, String date2, int p) {
		Pageable pageable = PageRequest.of(p, 5);
		Page<Order_address> s = addressRepo.showStatus(status,date1, date2, pageable);
		return s ;
	}

	@Override
	public void exportToExcel(HttpServletResponse response, int status, String date1, String date2) {
		response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
         
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);
        List<Order_address> listUsers = new ArrayList<Order_address>();
        if(status == 0) {
        	listUsers = addressRepo.exportAll( date1,  date2);
            
            
        }else {
        	listUsers = addressRepo.exportStatus( status,date1,  date2);
           
        }
         UserExcelExporter excelExporter = new UserExcelExporter(listUsers);
        try {
			excelExporter.export(response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    
		
	}
}
