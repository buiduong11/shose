package com.fa.shop.shoes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fa.shop.shoes.models.Product;

@Repository
public interface productRepository extends JpaRepository<Product, Integer>{

	@Query(value = "SELECT * FROM Product WHERE id_product = ?", nativeQuery = true)
	Product showProduct(int id_product);
	
	@Query(value = "UPDATE Product SET id_product = ?, id_product = ? WHRER id_product = ?", nativeQuery = true)
	Product updateProduct(int id_product);
	
	@Query(value = "SELECT * FROM Product WHERE id_product = ?", nativeQuery = true)
	Product product(int id_product);
	
	@Query(value = "SELECT * FROM product", nativeQuery = true)
	List<Product> showProductUserAll();
	
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM product WHERE id_product = ?", nativeQuery = true)
	void deleteProduct(int id_product);
	
	@Query(value = "SELECT COUNT(DISTINCT id_product) FROM product", nativeQuery = true)
	int countProduct();
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE product SET quantity = ?1 WHERE id_product = ?2", nativeQuery = true)
	int updateProductQuantity(double quantity, int id_product);
	
//	SELECT * FROM `product` WHERE title_product LIKE '%s%' 
	
	@Query(value = "SELECT * FROM `product` WHERE title_product LIKE %?1%", nativeQuery = true)
	List<Product> searchProduct(String search);
	
	@Query(value = "SELECT product.* "
			+ "FROM product INNER JOIN catagory ON product.id_product = catagory.id_category "
			+ "WHERE catagory.category = ?", nativeQuery = true)
	List<Product> Productcategory(String search);
	
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE product SET description = ?1, price = ?2, title_product = ?3 WHERE id_product = ?4", nativeQuery = true)
	int updateProduct(String description, double price, String title_product, int id);
}
