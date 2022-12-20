package com.fa.shop.shoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.fa.shop.shoes.models.User;

public interface userRepository extends JpaRepository<User, Integer>{

	@Query(value = "SELECT COUNT(DISTINCT id_user) FROM user", nativeQuery = true)
	int countUser();
	
	
	@Query(value = "SELECT * FROM user WHERE id_user = ?", nativeQuery = true)
	User profileUser(int id_user);
	
	@Query(value = "SELECT * FROM user WHERE email = ?1 AND password = ?2", nativeQuery = true)
	User login(String email, String pass);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE user SET password = ?2 WHERE id_user = ?1", nativeQuery = true)
	void Updatepassword(int id, String pass);
	
	@Query(value = "SELECT * FROM user WHERE id_user = ?1 AND password = ?2", nativeQuery = true)
	User checkPasswordUser(int id_user, String passsword);

}
