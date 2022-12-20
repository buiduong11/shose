package com.fa.shop.shoes.controllers;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.fa.shop.shoes.models.Address_order;
import com.fa.shop.shoes.models.Bill;
import com.fa.shop.shoes.models.Cart;
import com.fa.shop.shoes.models.Category;
import com.fa.shop.shoes.models.Comment;
import com.fa.shop.shoes.models.ImageProduct;
import com.fa.shop.shoes.models.Order;
import com.fa.shop.shoes.models.Product;
import com.fa.shop.shoes.models.Review;
import com.fa.shop.shoes.models.ReviewComment;
import com.fa.shop.shoes.models.Sizes;
import com.fa.shop.shoes.models.User;
import com.fa.shop.shoes.repository.address_orderRepository;
import com.fa.shop.shoes.repository.billRepository;
import com.fa.shop.shoes.repository.catagoryRepository;
import com.fa.shop.shoes.repository.commentRepository;
import com.fa.shop.shoes.repository.imageProductRepository;
import com.fa.shop.shoes.repository.orderRepository;
import com.fa.shop.shoes.repository.productRepository;
import com.fa.shop.shoes.repository.reviewCommentRepository;
import com.fa.shop.shoes.repository.reviewRepository;
import com.fa.shop.shoes.repository.sizesRepository;
import com.fa.shop.shoes.repository.userRepository;

@Controller
public class HomeController {
	
	@Autowired
	private productRepository productRepo;
	
	@Autowired
	private imageProductRepository imageProductRepo;
	
	@Autowired
	private commentRepository commentRepo;
	
	@Autowired
	private userRepository userRepo;
	
	@Autowired
	private address_orderRepository address_orderRepo;
	
	@Autowired
	private orderRepository orderRepo;
	
	@Autowired
	private sizesRepository sizesRepo;
	
	@Autowired
	private catagoryRepository catagoryRepo;
	
	@Autowired
	private billRepository billRepo;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired 
	private reviewRepository reviewRepo;
	
	@Autowired 
	private reviewCommentRepository reviewConmmRepo;
	
	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
    public String getLogin() {
		
        return "home/login";
    }
	
	@RequestMapping(value = {"/sign_out" }, method = RequestMethod.GET)
    public String sign_out(HttpSession session, HttpServletResponse response) {
    	
    	Cookie userNameCookieRemove = new Cookie("id", "");
    	userNameCookieRemove.setMaxAge(0);
    	response.addCookie(userNameCookieRemove);
    	
        return "redirect:/login";
    }
	
	@RequestMapping(value = { "/login" }, method = RequestMethod.POST)
    public String postLogin(@RequestParam String email, @RequestParam String password, HttpServletResponse response, Model model) {
    	
//		System.out.print(email);
		
		String passwMD5 = getMd5(password);
		
		User s = userRepo.login(email, passwMD5);
		
		if(s != null) {
			System.out.print(s.getId_user());
			
			if(s.getId_user() > 0) {
				Cookie cookie = new Cookie("id", String.valueOf(s.getId_user()));
				
				cookie.setMaxAge(7 * 24 * 60 * 60);
				
				response.addCookie(cookie);

				return "redirect:/index";
			}
		}else {
			model.addAttribute("notifi", "Dang nhap sai");
		}
		
        return "home/login";
    }
	@RequestMapping(value = { "/index" }, method = RequestMethod.GET)
    public String index(Model model, HttpServletRequest request) {
    	
		List<Product> list = productRepo.showProductUserAll();
		
		if(request.getCookies() != null) {
			for (Cookie c : request.getCookies()) {
	            if (c.getName().equals("id"))
	            {
	            	User s = userRepo.profileUser(Integer.parseInt(c.getValue()));
	            	model.addAttribute("user", s);
	            }
	         }
		}
		
		
		for (Product product : list) {
			List<ImageProduct> list_image = imageProductRepo.showImageProductAll(product.getId_product());
			product.setImages(list_image);
			System.out.print("image "+product.getImages().size());
		}
//		<img class="img-responsive" src="<%= product.getImages().get(0).getImage() %>" alt="product-img" />
		
    	model.addAttribute("product", list);
    	
        return "home/index";
    }
	@RequestMapping(value = { "index/page" }, method = RequestMethod.GET)
    public String indexPage(Model model, HttpServletRequest request, @RequestParam("p") Optional<Integer> p) {
		if(request.getCookies() != null) {
			for (Cookie c : request.getCookies()) {
	            if (c.getName().equals("id"))
	            {
	            	User s = userRepo.profileUser(Integer.parseInt(c.getValue()));
	            	model.addAttribute("user", s);
	            }
	         }
		}
		List<Product> list = productRepo.showProductUserAll();
		Pageable pageable = PageRequest.of(1, 5);
		Page<Product> s = productRepo.findAll(pageable);
		System.out.println("imagej "+s.getContent());
		for (Product product : s.getContent()) {
//			List<ImageProduct> list_image = imageProductRepo.showImageProductAll(product.getId_product());
//			product.setImages(list_image);
			System.out.println("imagej "+product.getId_product());
		}

		System.out.println("image "+s.getNumber());
    	model.addAttribute("product", s);
    	
        return "home/login";
	}
	@RequestMapping(value = { "/register" }, method = RequestMethod.GET)
    public String getRegister(Model model) {
    	
		
		
        return "home/signin";
    }
	
	void sendEmail(String mail) throws MessagingException, IOException {

		MimeMessage msg = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
        helper.setFrom("eeb6f429d5-840eb3@inbox.mailtrap.io");
        helper.setTo(mail);
        helper.setSubject("Testing from Spring Boot");
        helper.setText("<h1>Ban da dat hang thanh cong</h1>", true);

//        msg.addAttachment("my_photo.png", new ClassPathResource("android.png"));

        javaMailSender.send(msg);

    }
	
	@RequestMapping(value = { "/register" }, method = RequestMethod.POST)
    public String postRegister(
    		@RequestParam String fisrtName, 
    		@RequestParam String lastName,
    		@RequestParam String email,
    		@RequestParam String phone,
    		@RequestParam String password, 
    		Model model) {
		
		List<User> list = userRepo.findAll();
		for (User user : list) {
			
			if(user.getEmail().equals(email)) {
				System.out.println(user.getEmail());

				model.addAttribute("notifi", "email da duoc su dung");
//				
				return "home/signin";
			}else if(user.getPhone().equals(phone)) {
				model.addAttribute("notifi", "so dien thoai da duoc su dung");
				return "home/signin";
			}else if(user.getEmail().equals(email) && user.getPhone().equals(phone)){
				model.addAttribute("notifi", "so dien thoai vaf mail da duoc su dung");
				return "home/signin";
			}
		}
			
		User users = userRepo.save(new User(fisrtName, lastName, email, getMd5(password), 2, phone));
		
		return "redirect:/login";
        
    }
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = { "/cart" }, method = RequestMethod.GET)
    public String cart(HttpSession session, Model model, HttpServletRequest request) {
		
		if(request.getCookies() != null) {
			for (Cookie c : request.getCookies()) {
	            if (c.getName().equals("id"))
	            {
	            	User s = userRepo.profileUser(Integer.parseInt(c.getValue()));
	            	model.addAttribute("user", s);
	            }
	         }
		}
		
		List<Cart> messages = new ArrayList<>();
		messages = (List<Cart>) session.getAttribute("MY_SESSION_MESSAGES");
		if(messages != null) {
			System.out.print(messages.size());
			for (Cart list : messages) {
				Product listProduct = productRepo.showProduct(list.getId());
		    	List<ImageProduct> list_image = imageProductRepo.showImageProductAll(list.getId());
		    	list.setTitle(listProduct.getTitle_product());
		    	list.setPrice(listProduct.getPrice());
		    	list.setImage(list_image.get(0).getImage());
			}
		}
		
		model.addAttribute("cart",messages);
        return "home/cart";
    }
	
//	@SuppressWarnings("unchecked")
//	@RequestMapping(value = { "/cart/remove" }, method = RequestMethod.POST)
//    public List<Cart> cartRemove(@RequestParam String id ,HttpSession session) {
//		
//		List<Cart> messages = new ArrayList<>();
//		messages = (List<Cart>) session.getAttribute("MY_SESSION_MESSAGES");
//		if(messages != null) {
////			System.out.print(messages.size());
//			for (Cart list : messages) {
//				if(list.getId() == Integer.parseInt(id)) {
//					messages.remove(list);
//					break;
//				}
//			}
//			if(messages != null) {
//				for (Cart list : messages) {
//					Product listProduct = productRepo.showProduct(list.getId());
//			    	List<ImageProduct> list_image = imageProductRepo.showImageProductAll(list.getId());
//			    	list.setTitle(listProduct.getTitle_product());
//			    	list.setPrice(listProduct.getPrice());
//			    	list.setImage(list_image.get(0).getImage());
//				}
////				model.addAttribute("cart",messages);
//			}
//		}
//		
//        return messages;
//    }
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = { "/cart/update" }, method = RequestMethod.GET)
    public String cartUpdate(@RequestParam int id ,HttpSession session, Model model) {
		
		List<Cart> messages = new ArrayList<>();
		messages = (List<Cart>) session.getAttribute("MY_SESSION_MESSAGES");
		if(messages != null) {
			System.out.print(messages.size());
			for (Cart list : messages) {
				if(list.getId() == id) {
					
				}
			}
			if(messages != null) {
				for (Cart list : messages) {
					Product listProduct = productRepo.showProduct(list.getId());
			    	List<ImageProduct> list_image = imageProductRepo.showImageProductAll(list.getId());
			    	list.setTitle(listProduct.getTitle_product());
			    	list.setPrice(listProduct.getPrice());
			    	list.setImage(list_image.get(0).getImage());
				}
				model.addAttribute("cart",messages);
			}
		}
		
        return "home/cart";
    }
	
	@RequestMapping(value = { "/address" }, method = RequestMethod.GET)
    public String address(
    		@RequestParam(name = "product-quantity") String product_quantity) {
    	
        return "home/address";
    }
	@RequestMapping(value = { "/order" }, method = RequestMethod.GET)
    public String order(Model model, HttpServletRequest request) {
		
		
		 for (Cookie c : request.getCookies()) {
             if (c.getName().equals("id"))
             {
            	 User s = userRepo.profileUser(Integer.parseInt(c.getValue()));
	            	model.addAttribute("user", s);
            	 List<Bill> list = billRepo.shoewBillUser(Integer.parseInt(c.getValue()));
              	 model.addAttribute("bill", list);
             }
          }
		
        return "home/order";
    }
	@RequestMapping(value = { "/shop" }, method = RequestMethod.GET)
    public String shop() {


        return "home/shop";
    }
	@RequestMapping(value = { "/dashboard" }, method = RequestMethod.GET)
    public String dashboard() {
//		int ss = productRepo.updateProductQuantity(1.0, 1);
        return "home/dashboard";
    }
	@RequestMapping(value = { "/confirmation" }, method = RequestMethod.GET)
    public String confirmation(HttpServletRequest request, Model model) {
		if(request.getCookies() != null) {
			for (Cookie c : request.getCookies()) {
	            if (c.getName().equals("id"))
	            {
	            	User s = userRepo.profileUser(Integer.parseInt(c.getValue()));
	            	model.addAttribute("user", s);
	            	 return "home/confirmation";
	            }
	         }
		}
		return "redirect:/login";
       
    }
	@RequestMapping(value = { "/profile-details" }, method = RequestMethod.GET)
    public String profile_details(Model model, HttpServletRequest request) {

		
		for (Cookie c : request.getCookies()) {
            if (c.getName().equals("id"))
            {
            	User user = userRepo.profileUser(Integer.parseInt(c.getValue()));
        		model.addAttribute("user" ,user);
        		return "home/profile-details";
            }
         }
		
       
        return "redirect:/login";
    }
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = { "/checkout" }, method = RequestMethod.GET)
    public String checkout(HttpSession session ,Model model, HttpServletRequest request) {
		
		if(request.getCookies().length !=0 ) {
			for (Cookie c : request.getCookies()) {
	            if (c.getName().equals("id"))
	            {
	            	User s = userRepo.profileUser(Integer.parseInt(c.getValue()));
	            	model.addAttribute("user", s);
	            	List<Cart> messages = new ArrayList<>();
	        		messages = (List<Cart>) session.getAttribute("MY_SESSION_MESSAGES");
	        		if(messages != null) {
	        			System.out.print(messages.size());
	        			for (Cart list : messages) {
	        				Product listProduct = productRepo.showProduct(list.getId());
	        		    	List<ImageProduct> list_image = imageProductRepo.showImageProductAll(list.getId());
	        		    	list.setTitle(listProduct.getTitle_product());
	        		    	list.setPrice(listProduct.getPrice());
	        		    	list.setImage(list_image.get(0).getImage());
	        			}
	        			model.addAttribute("cart",messages);
	        		}
	        		 return "home/checkout";
	            }
	         }
		}
		return "redirect:/login";
      
    }
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = { "/checkout" }, method = RequestMethod.POST)
    public String checkoutPost(HttpSession session, @RequestParam String fullname,@RequestParam String address,
    		@RequestParam String phone, HttpServletRequest request) throws IOException, MessagingException {
		if(request.getCookies() != null) {
			for (Cookie c : request.getCookies()) {
	            if (c.getName().equals("id"))
	            {
	            	List<Cart> messages = new ArrayList<>();
	        		messages = (List<Cart>) session.getAttribute("MY_SESSION_MESSAGES");
	        		List<Order> s = new ArrayList<Order>();
	        		List<Product> listProducti = productRepo.findAll();
	        		List<Sizes> sizes = sizesRepo.findAll();
	        		String pattern = "yyyy-MM-dd";
	        		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
	        		String date = simpleDateFormat.format(new Date());
	        		if(messages != null) {
	        			long id = ZonedDateTime.now().toInstant().toEpochMilli();
	        			for (Cart list : messages) {
		        				for (Sizes size : sizes) {
		        					System.out.print("hihihi "+list.getId());
		        					if(list.getId() == size.getId_size_product() && list.getSize() == size.getId()) {
		        						System.out.print("XIN CHAO");
			        					double quantity = (size.getQuantity() - list.getQuantity());
			        					if(quantity >= 0) {
			        						Address_order address_order = address_orderRepo.save(new Address_order(fullname, address, phone));
			        						Order order = new Order(Math.abs((int)id), Integer.parseInt(c.getValue()),
			        								list.getId(), 
					        						address_order.getId_address_order(), 
					        						list.getPrice(), list.getQuantity(),
					        						list.getSize(), 1, date);
				        					sizesRepo.updateSizeQuantity(quantity, size.getId());
					        				s.add(order);
				        				}
			        				}
								}
//		        			}
	        			}
	        			if(s != null) {
	        				orderRepo.saveAll(s);
	        				User ss = userRepo.profileUser(Integer.parseInt(c.getValue()));
	        				List<Cart> messagess = new ArrayList<>();
	        				session.setAttribute("MY_SESSION_MESSAGES", messagess);
	        			}
	        		}else {
	        			return "redirect:/index";
	        		}
	        		
	            }
	            
	         }
		}
		
	
		
        return "redirect:/confirmation";
    }
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = { "/product-single" }, method = RequestMethod.GET)
    public String product_single(@RequestParam int id, Model model, HttpServletRequest request) {

		if(request.getCookies() != null) {
			for (Cookie c : request.getCookies()) {
	            if (c.getName().equals("id"))
	            {
	            	User s = userRepo.profileUser(Integer.parseInt(c.getValue()));
	            	model.addAttribute("user", s);
	            }
	         }
		}
		Product list = productRepo.product(id);
		List<ImageProduct> list_image = imageProductRepo.showImageProductAll(list.getId_product());
		list.setImages(list_image);
		List<Comment> list_comment = commentRepo.showCommentUserProduct(id);
		list.setComment(list_comment);
		
		List<Sizes> sizes = sizesRepo.showSizeProduct(id);
		list.setSizes(sizes);
		
		List<Category> category = catagoryRepo.showCategoryProduct(id);
		list.setCategory(category);
		
		
		model.addAttribute("product", list);
		
        return "home/product-single";
    }
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = { "/product-single" }, method = RequestMethod.POST)
    public String Postproduct_single(
    		@RequestParam(name = "id") int id,
    		@RequestParam(name = "size") int size,
    		@RequestParam(name = "product-quantity") int quantity,
    		Model model, 
    		HttpSession session) {
		
		if(size != 0 && quantity != 0) {
			
			List<Cart> messages = (List<Cart>) session.getAttribute("MY_SESSION_MESSAGES");
			List<Cart> messa = new ArrayList<>();
			if(messages == null || messages.size() == 0) {
				messages = new ArrayList<>();
				session.setAttribute("MY_SESSION_MESSAGES", messages);
				
				Cart carts = new Cart(id, quantity, size);
				messages.add(carts);
				session.setAttribute("MY_SESSION_MESSAGES", messages);
				
			}else {
				System.out.print("babab "+messages.size() );
				Cart cart = new Cart(id, quantity, size);
				for(Cart k : messages) {
					System.out.print(k.getId() == cart.getId());
					if(k.getId() == cart.getId() && k.getSize() == cart.getSize()) {
						model.addAttribute("notifi", "adasdasdasd");
						System.out.print("ngngng");
						int s = (int) (k.getQuantity() + quantity);
						System.out.print("quant "+s);
						k.setQuantity(s);
					}else {
						System.out.println("hihi"+"\n");
						messa.add(cart);
//						session.setAttribute("MY_SESSION_MESSAGES", messages);
					}
					
				}
				if(messa.size() > 0) {
					messages.add(messa.get(0));
					//System.out.println("hihi3"+messa.size()+"\n");
				}
				
			}
			
		}
		
		System.out.print(id);
		
        return "redirect:/product-single?id="+String.valueOf(id);
    }
	
	@RequestMapping(value = { "/addRecomment" }, method = RequestMethod.POST)
    public String addRecomment(@RequestParam(name = "id") int id, @RequestParam String review,HttpServletRequest request) {
    	
//		System.out.print(review);
		if(request.getCookies() != null) {
		for (Cookie c : request.getCookies()) {
            if (c.getName().equals("id"))
            {
            	Review s = new Review("",review);
        		Review reviews = reviewRepo.save(s);
        		
        		String pattern = "yyyy-MM-dd";
        		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        		String date = simpleDateFormat.format(new Date());
        		
        		ReviewComment ss = new ReviewComment(Integer.parseInt(c.getValue()),
        				id,reviews.getId_review(),date);
        		
        		reviewConmmRepo.save(ss);
            }
         }
		}
		
        return "redirect:/product-single?id="+String.valueOf(id);
    }
	
	@RequestMapping(value = { "/show" }, method = RequestMethod.GET)
    public String show(@RequestParam int id, Model model, HttpServletRequest request) {
    	
		if(request.getCookies() != null) {
			for (Cookie c : request.getCookies()) {
	            if (c.getName().equals("id"))
	            {
	            	User s = userRepo.profileUser(Integer.parseInt(c.getValue()));
	            	model.addAttribute("user", s);
	            }
	         }
		}
		List<Order> listorder = orderRepo.show(id);
		List<Cart> messages = new ArrayList<>();
		Address_order address = address_orderRepo.showAddress(listorder.get(0).getId_address_order());
//		if(messages != null) {
//			System.out.print(messages.size());
			
			for(int i = 0 ; i < listorder.size() ; i++) {
				Product listProduct = productRepo.showProduct(listorder.get(i).getId_product());
		    	List<ImageProduct> list_image = imageProductRepo.showImageProductAll(listorder.get(i).getId_product());
		    	messages.add(new Cart(listorder.get(i).getId_bill(), listorder.get(i).getQuantity(), 
		    			listorder.get(i).getSize(), listProduct.getTitle_product(), list_image.get(0).getImage(), listProduct.getPrice()));
			}
			model.addAttribute("cart",messages);
			model.addAttribute("address",address);
//		}
		
        return "home/showOrder";
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
	
	@RequestMapping(value = { "/searchProduct" }, method = RequestMethod.GET)
	public String search(@RequestParam String search, Model model, HttpServletRequest request) {
		List<Product> list = productRepo.searchProduct(search);
		
		System.out.print(search);
		if(request.getCookies() != null) {
			for (Cookie c : request.getCookies()) {
	            if (c.getName().equals("id"))
	            {
	            	User s = userRepo.profileUser(Integer.parseInt(c.getValue()));
	            	model.addAttribute("user", s);
	            }
	         }
		}
		
		for (Product product : list) {
			List<ImageProduct> list_image = imageProductRepo.showImageProductAll(product.getId_product());
			product.setImages(list_image);
		}
		
		
		
    	model.addAttribute("product", list);
		return "home/shop";
	}
	
	@RequestMapping(value = { "/searchProductImage" }, method = RequestMethod.GET)
	public String searchImage(@RequestParam String search, Model model, HttpServletRequest request) {
		final String uri = "http://127.0.0.1:5000/image";
		RestTemplate restTemplate = new RestTemplate();
		Object[] result = restTemplate.getForObject(uri, Object[].class);
		
		
		return "home/shop";
	}
}
