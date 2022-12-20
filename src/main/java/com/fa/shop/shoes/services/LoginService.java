package com.fa.shop.shoes.services;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.Cookie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fa.shop.shoes.services.IService.ILoginService;
import com.fa.shop.shoes.models.ChangePassword;
import com.fa.shop.shoes.models.User;
import com.fa.shop.shoes.repository.userRepository;

@Service
public class LoginService implements ILoginService{

	@Autowired
	private userRepository userRepo;
	
	@Override
	public String ChangePassword(ChangePassword changePassword) {
	
		String md5Password = getMd5(changePassword.getPassword());
		User user = userRepo.checkPasswordUser(changePassword.getId(), md5Password);
		if(user != null) {
			String md5PasswordNew =  getMd5(changePassword.getPassword_new());
			 userRepo.Updatepassword(changePassword.getId(), md5PasswordNew);
		}else {
			return "Password ko trung khop";
		}
		
		return "Password ddax thay doi";
		
	}
	public String getMd5(String input)
    {
        try {
  
            MessageDigest md = MessageDigest.getInstance("MD5");
  
            byte[] messageDigest = md.digest(input.getBytes());
  
            BigInteger no = new BigInteger(1, messageDigest);
  
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } 
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

}
