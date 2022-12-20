package com.fa.shop.shoes.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fa.shop.shoes.models.ProductionApi;


@Repository
public interface productionApiRepository extends JpaRepository<ProductionApi, Integer>{

	@Query(value = "SELECT id_product, title_product, description, price, SUM(size_product.quantity) AS quantity, image.image FROM `product` INNER JOIN (SELECT * FROM `image_product` GROUP BY id_image_product) AS image ON product.id_product = image.id_image_product INNER JOIN size_product ON id_product = size_product.id_size_product GROUP BY id_product ORDER BY id"
			,countQuery = "SELECT id_product, title_product, description, price, SUM(size_product.quantity) AS quantity, image.image FROM `product` INNER JOIN (SELECT * FROM `image_product` GROUP BY id_image_product) AS image ON product.id_product = image.id_image_product INNER JOIN size_product ON id_product = size_product.id_size_product GROUP BY id_product", nativeQuery = true)
	public Page<ProductionApi> showProduct(Pageable pageable);
	
}
