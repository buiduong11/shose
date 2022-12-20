package com.fa.shop.shoes.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fa.shop.shoes.models.ChangePassword;
import com.fa.shop.shoes.models.User;
import com.fa.shop.shoes.services.IService.ILoginService;

@RestController
public class LoginHomeController {

	private ILoginService Iloginservice;
	public LoginHomeController(ILoginService Iloginservice) {
		this.Iloginservice = Iloginservice;
	}
	
	@PostMapping("/changePassword")
	public String changePassword(@RequestBody ChangePassword s) {
		return Iloginservice.ChangePassword(s);
	}
	

}
