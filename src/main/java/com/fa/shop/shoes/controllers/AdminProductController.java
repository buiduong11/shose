package com.fa.shop.shoes.controllers;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.fa.shop.shoes.models.Address_order;
import com.fa.shop.shoes.models.Category;
import com.fa.shop.shoes.models.ImageProduct;
import com.fa.shop.shoes.models.Order;
import com.fa.shop.shoes.models.Product;
import com.fa.shop.shoes.models.Review;
import com.fa.shop.shoes.models.Sizes;
import com.fa.shop.shoes.repository.catagoryRepository;
import com.fa.shop.shoes.repository.imageProductRepository;
import com.fa.shop.shoes.repository.productRepository;
import com.fa.shop.shoes.repository.sizesRepository;

@Controller
public class AdminProductController {
	
	@Autowired
	private productRepository productRepo;
	
	@Autowired
	private imageProductRepository imageProductRepo;
	
	@Autowired
	private catagoryRepository catagoryRepo;
	
	@Autowired
	private sizesRepository sizesRepo;
	
	//private String saveDirectory = "E:/fpt software/Project/shoes/src/main/resources/static/assets/images/images";
	
	
	  @RequestMapping(value = "/admin/product",method = RequestMethod.GET)
	  public String product(HttpServletRequest request,Model model) {
		if(request.getCookies() != null) {
			for (Cookie c : request.getCookies()) {
	            if (c.getName().equals("idAdmin"))
	            {
	            	List<Product> list = productRepo.showProductUserAll();
//	        	  	for (Product product : list) {
//	        			List<ImageProduct> list_image = imageProductRepo.showImageProductAll(product.getId_product());
//	        			product.setImages(list_image);
//	        		}
	        	  	model.addAttribute("product", list);
	        	      return "admin/product";
	            }
			}
    	}
    	
        return "redirect:/admin/login";
	  }
	
	@RequestMapping(value = { "/admin/show_product" }, method =  RequestMethod.GET)
    public String show_product(@RequestParam int id,HttpServletRequest request,Model model) {
		if(request.getCookies() != null) {
			for (Cookie c : request.getCookies()) {
	            if (c.getName().equals("idAdmin"))
	            {
	            	System.out.println(id);
	            	Product list = productRepo.showProduct(id);
	            	System.out.println(list.getDescription());
	            	List<ImageProduct> list_image = imageProductRepo.showImageProductAll(id);
	            	List<Category> list_categoty = catagoryRepo.showCategoryProduct(id);
	            	List<Sizes> list_size = sizesRepo.showSizeProduct(id);
	            	
	            	list.setSizes(list_size);
	        		list.setImages(list_image);
	        		list.setCategory(list_categoty);
	            	model.addAttribute("product", list);
	                return "admin/show_product";
	            }
			}
    	}
    	
        return "redirect:/admin/login";
    	
    }
	
	@RequestMapping(value = { "/admin/add_product" }, method =  RequestMethod.GET)
    public String show_add_product(HttpServletRequest request) {
		
		if(request.getCookies() != null) {
			for (Cookie c : request.getCookies()) {
	            if (c.getName().equals("idAdmin"))
	            {
	            	return "admin/add_product";
	            }
			}
    	}
    	
        return "redirect:/admin/login";
        
    	
    }
	
	@RequestMapping(value = { "/admin/add_product" }, method =  RequestMethod.POST)
    public String add_product(@RequestParam String title,
    		@RequestParam String category,
    		@RequestParam double price, 
    		@RequestParam String description,
    		@RequestParam List<String> size,
    		@RequestParam List<Double> quantity,
    		@RequestParam List<MultipartFile> file) {
		
		Product product = new Product(description, price, title);
		productRepo.save(product);
		Category categorys = new Category(product.getId_product(), category);
		catagoryRepo.save(categorys);
		for(int i = 0 ; i < size.size() ; i++) {
			Sizes s = new Sizes(product.getId_product(),size.get(i), quantity.get(i));
			sizesRepo.save(s);
		}
		
		
		String uploadDir = "image_product/" + product.getId_product();
		imageProductRepo.deleteImageProduct(product.getId_product());
		for(int i = 0 ; i < file.size() ; i++) {
			
			if(file.get(i).getOriginalFilename() != null) {
				
				String fileName = StringUtils.cleanPath(file.get(i).getOriginalFilename());
		        try {
					String path = saveFile(uploadDir, fileName, file.get(i));
					ImageProduct im = new ImageProduct(product.getId_product(), "/"+uploadDir+"/"+fileName);
					imageProductRepo.save(im);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        
			}
			
		}
		
        return "redirect:/admin/product";
    	
    }
	
	@RequestMapping(value = { "/admin/edit_product" }, method =  RequestMethod.POST)
    public String edit_product(
    		@RequestParam int id,
    		@RequestParam String title,
    		@RequestParam String category,
    		@RequestParam double price, 
    		@RequestParam String description,
    		@RequestParam List<String> size,
    		@RequestParam List<Double> quantity,
    		@RequestParam List<MultipartFile> file
    		) {
	
		int updateProduct = productRepo.updateProduct(description, price, title, id);
		int updateCategory = catagoryRepo.updateCategoty(id, category);
		
		sizesRepo.deleteSizeProduct(id);
		for(int i = 0 ; i < size.size() ; i++) {
			Sizes s = new Sizes(id,size.get(i), quantity.get(i));
			sizesRepo.save(s);
		}
		
		System.out.print("LLL "+file.get(0).getOriginalFilename());
		System.out.print("LLL "+file.get(0).getResource());
		
		String uploadDir = "image_product/" + id;
		imageProductRepo.deleteImageProduct(id);
		for(int i = 0 ; i < file.size() ; i++) {
			
			if(file.get(i).getOriginalFilename() != null) {
				
				String fileName = StringUtils.cleanPath(file.get(i).getOriginalFilename());
		        try {
					String path = saveFile(uploadDir, fileName, file.get(i));
					ImageProduct im = new ImageProduct(id, "/"+uploadDir+"/"+fileName);
					imageProductRepo.save(im);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        
			}
//			
		}
    	
        return "redirect:/admin/product";
    	
    }
	
	 public static String saveFile(String uploadDir, String fileName,
	            MultipartFile multipartFile) throws IOException {
	        Path uploadPath = Paths.get(uploadDir);
	         
	        if (!Files.exists(uploadPath)) {
	            Files.createDirectories(uploadPath);
	        }
	        Path filePath = null;
	        try (InputStream inputStream = multipartFile.getInputStream()) {
	            filePath = uploadPath.resolve(fileName);
	            System.out.print("path"+filePath.toString());
	            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
	        } catch (IOException ioe) {        
	            throw new IOException("Could not save image file: " + fileName, ioe);
	        }   
	        return filePath.toString();
	    }
	
	@RequestMapping(value = { "/admin/delete_product" }, method =  RequestMethod.GET)
    public String delete_product(@RequestParam int id,HttpServletRequest request,Model model) {
    	System.out.println(id);
    	
    	productRepo.deleteProduct(id);
    	imageProductRepo.deleteImageProduct(id);
    	sizesRepo.deleteSizeProduct(id);
    	List<Product> list = productRepo.showProductUserAll();

	  	model.addAttribute("product", list);
        return "admin/product";
    }
	
	
}
