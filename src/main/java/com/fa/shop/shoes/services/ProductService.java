package com.fa.shop.shoes.services;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.fa.shop.shoes.models.Image;
import com.fa.shop.shoes.models.ImageProduct;
import com.fa.shop.shoes.models.Production;
import com.fa.shop.shoes.models.Size;
import com.fa.shop.shoes.models.Sizes;
import com.fa.shop.shoes.repository.catagoryRepository;
import com.fa.shop.shoes.repository.imageProductRepository;
import com.fa.shop.shoes.repository.productRepository;
import com.fa.shop.shoes.repository.sizesRepository;
import com.fa.shop.shoes.services.IService.IProductService;

@Service
public class ProductService implements IProductService{

	@Autowired
	private productRepository productRepo;
	
	@Autowired
	private catagoryRepository catagoryRepo;
	
	@Autowired
	private imageProductRepository imageProductRepo;
	
	@Autowired
	private sizesRepository sizesRepo;
	
	@Override
	public void editProduct(Image obj) {
		// TODO Auto-generated method stub

		System.out.print(obj.getId_image());
		
		MultipartFile file = obj.getFileImage();
		String uploadDir = "image_product/" + 1;
		
		if(file.getOriginalFilename() != null) {
			
			String fileName = StringUtils.cleanPath(file.getOriginalFilename());
			
	        try {
	        	
				String path = saveFile(uploadDir, fileName, file);
				//System.out.println("kaka "+obj.getId_image());
				if(obj.getId_image() == 0) {
					System.out.print(obj.getId_image());
					ImageProduct s = new ImageProduct(obj.getId_image_product(),"/"+uploadDir+"/"+fileName);
					imageProductRepo.save(s);
				}
				if(obj.getId_image() != 0) {
					System.out.println("kaka "+obj.getId_image());
					
					if(obj.getFileImage() == null) {
						//sizesRepo.deleteSizeProduct(obj.getId());
						System.out.println("remove "+obj.getFileImage());
					}else {
						imageProductRepo.updateImageProduct(obj.getId_image(), "/"+uploadDir+"/"+fileName);
					}
				}
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
	        
		}
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

	@Override
	public void editSize(Size obj) {
		// TODO Auto-generated method stub
		if(obj.getId() == 0) {
//			System.out.print(obj.getId());
			Sizes s = new Sizes(obj.getId_size_product(),obj.getSize(), obj.getQuantity());
			sizesRepo.save(s);
		}else if(obj.getId() != 0) {
//			System.out.println(obj.getSize());
			if(obj.getQuantity() == 0 || obj.getSize().equals("")) {
				sizesRepo.deleteSizeProduct(obj.getId());
				System.out.println("remove "+obj.getId());
			}else {
				sizesRepo.updateSizeProduct(obj.getId(), obj.getSize(), obj.getQuantity());
			}
		}
		
		
	}

	@Override
	public void editProduct(Production obj) {
		
		int updateProduct = productRepo.updateProduct(obj.getDescription(), obj.getPrice(), obj.getTitle_product(), obj.getId_product());
		int updateCategory = catagoryRepo.updateCategoty(obj.getId_product(), obj.getCategory());
		System.out.print(obj.getCategory());
		
	}

}
