package com.fa.shop.shoes.controllers;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fa.shop.shoes.models.Address_order;
import com.fa.shop.shoes.models.Bill;
import com.fa.shop.shoes.models.Cart;
import com.fa.shop.shoes.models.ImageProduct;
import com.fa.shop.shoes.models.Order;
import com.fa.shop.shoes.models.Product;
import com.fa.shop.shoes.models.Review;
import com.fa.shop.shoes.models.User;
import com.fa.shop.shoes.models.UserBill;
import com.fa.shop.shoes.repository.address_orderRepository;
import com.fa.shop.shoes.repository.billRepository;
import com.fa.shop.shoes.repository.imageProductRepository;
import com.fa.shop.shoes.repository.orderRepository;
import com.fa.shop.shoes.repository.productRepository;
import com.fa.shop.shoes.repository.reviewRepository;
import com.fa.shop.shoes.repository.userRepository;
import com.fa.shop.shoes.repository.userbillRepository;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
	
	@Autowired
	private productRepository productRepo;
	
	@Autowired
	private billRepository billRepo;
	
	@Autowired
	private userRepository userRepo;
	
	@Autowired
	private reviewRepository reviewRepo;
	
	@Autowired
	private userbillRepository userbillRepo;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
	private orderRepository orderRepo;
	
	@Autowired
	private address_orderRepository address_orderRepo;
	
	@Autowired
	private imageProductRepository imageProductRepo;
	
    @RequestMapping(value = {"/login" }, method = RequestMethod.GET)
    public String index() {
    	
        return "admin/login";
    }
    @RequestMapping(value = {"/sign_out" }, method = RequestMethod.GET)
    public String sign_out(HttpSession session, HttpServletResponse response) {
    	
    	Cookie userNameCookieRemove = new Cookie("idAdmin", "");
    	userNameCookieRemove.setMaxAge(0);
    	response.addCookie(userNameCookieRemove);
    	
        return "redirect:/admin/login";
    }
    
    @RequestMapping(value = { "/login" }, method = RequestMethod.POST)
    public String postLogin(@RequestParam String email, @RequestParam String password, HttpServletResponse response) {
    	
		System.out.print(email);
		
		String passwMD5 = getMd5(password);
		
		User s = userRepo.login(email, passwMD5);
		
		
		
		if(s != null && s.getRole() == 1) {
			Cookie cookie = new Cookie("idAdmin", String.valueOf(s.getId_user()));
			
			cookie.setMaxAge(7 * 24 * 60 * 60);
			
			response.addCookie(cookie);
			return "redirect:/admin/dashboard";
		}
		
        return "admin/login";
    }

    @RequestMapping(value = { "/dashboard" })
    public String list(HttpServletRequest request,Model model) {
    	if(request.getCookies() != null) {
			for (Cookie c : request.getCookies()) {
	            if (c.getName().equals("idAdmin"))
	            {
	            	int countOrder = billRepo.countBill();
	            	int countUser = userRepo.countUser();
	            	int countProduct = productRepo.countProduct();
	            	List<UserBill> list = userbillRepo.UserMaxBill();
	            	
	            	model.addAttribute("countOrder", countOrder);
	            	model.addAttribute("countProduct", countProduct);
	            	model.addAttribute("countUser", countUser);
	            	model.addAttribute("list", list);

	                return "admin/dashboard";
	            }
	         }
		}
    	return "redirect:/admin/login";
    }
    
//    @RequestMapping(value = {"/add_product"}, method = RequestMethod.GET)
//    public String add_product_form(Model model) {
//    	model.addAttribute("product", new Product());
//    	return "admin/add_product";
//    }
    
//    @RequestMapping(value = {"/add_product"}, method = RequestMethod.POST)
//    public String add_product_submit(@ModelAttribute Product product,Model model) {	
//    	
//    	System.out.print(product.getTitle_product());
//    	return "admin/add_product";
//    }
    
    
    @RequestMapping(value = { "/user" }, method =  RequestMethod.GET)
    public String custom(HttpServletRequest request,Model model) {
    	
    	if(request.getCookies() != null) {
			for (Cookie c : request.getCookies()) {
	            if (c.getName().equals("idAdmin"))
	            {
	            	List<User> list = userRepo.findAll();
	            	model.addAttribute("user", list);
	            	 return "admin/customer";
	            }
			}
    	}
    	
        return "redirect:/admin/login";
       
    }
    
    @RequestMapping(value = { "/review" }, method =  RequestMethod.GET)
    public String review(HttpServletRequest request,Model model) {
    	if(request.getCookies() != null) {
			for (Cookie c : request.getCookies()) {
	            if (c.getName().equals("idAdmin"))
	            {
	            	List<Review> list = reviewRepo.findAll();
	            	model.addAttribute("review", list);
	                return "admin/review";
	            }
			}
    	}
    	
        return "redirect:/admin/login";
    }
    
   
    
    @RequestMapping(value = { "/show_order" }, method =  RequestMethod.GET)
    public String show_order(@RequestParam int id,HttpServletRequest request,Model model) {
    	System.out.println(id);
    	Product list = productRepo.showProduct(1);
    	System.out.println(list.getDescription());
    	model.addAttribute("product", list);
        return "admin/show_product";
    }
    
    void sendEmail() {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("cif00690@cuoly.com");

        msg.setSubject("Testing from Spring Boot");
        msg.setText("Hello World \n Spring Boot Email");

        javaMailSender.send(msg);

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
    
    @RequestMapping(value = { "/show" }, method = RequestMethod.GET)
    public String show(@RequestParam int id, Model model, HttpServletRequest request) {
    	
		List<Order> listorder = orderRepo.show(id);
		List<Cart> messages = new ArrayList<>();
		
		  if(listorder != null ) {
			Address_order address = address_orderRepo.showAddress(listorder.get(0).getId_address_order());
//			System.out.print(messages.size());
			
			for(int i = 0 ; i < listorder.size() ; i++) {
				Product listProduct = productRepo.showProduct(listorder.get(i).getId_product());
		    	List<ImageProduct> list_image = imageProductRepo.showImageProductAll(listorder.get(i).getId_product());
		    	messages.add(new Cart(listorder.get(i).getId_bill(), listorder.get(i).getQuantity(), 
		    			listorder.get(i).getSize(), listProduct.getTitle_product(), list_image.get(0).getImage(), 
		    			listProduct.getPrice(), listorder.get(i).getId()));
			}
			model.addAttribute("cart",messages);
			model.addAttribute("address",address);
		}
		
        return "admin/showOrder";
    }
    
    @RequestMapping(value = { "/thongke" }, method = RequestMethod.GET)
    public String thongke() {
    	return "";
    }
    
    
}
