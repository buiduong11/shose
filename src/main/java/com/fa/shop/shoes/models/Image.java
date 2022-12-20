package com.fa.shop.shoes.models;

import org.springframework.web.multipart.MultipartFile;

public class Image {
	private int id_image;
	private int id_image_product;
	
	private MultipartFile fileImage;

	public int getId_image() {
		return id_image;
	}

	public void setId_image(int id_image) {
		this.id_image = id_image;
	}

	public int getId_image_product() {
		return id_image_product;
	}

	public void setId_image_product(int id_image_product) {
		this.id_image_product = id_image_product;
	}

	public MultipartFile getFileImage() {
		return fileImage;
	}

	public void setFileImage(MultipartFile fileImage) {
		this.fileImage = fileImage;
	}
	
	
	
}
