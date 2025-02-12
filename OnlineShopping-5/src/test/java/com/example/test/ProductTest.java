package com.example.test;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.pojo.Admin;
import com.example.pojo.Product;
import com.example.pojo.User;
import com.example.repo.AdminRepositoryImpl;
import com.example.repo.ProductRepositoryImpl;
import com.example.repo.UserRepositoryImpl;

@SpringBootTest
public class ProductTest {

	@Autowired
	ProductRepositoryImpl productRepo;

	@Autowired
	AdminRepositoryImpl adminRepo;

	@Autowired
	UserRepositoryImpl userRepo;

	@Test
	void insertProductTest() {
		Product product = new Product();

		product.setPrice(1500);
		product.setImage("img-2");
		product.setDescription("Office");
		product.setBrand("Bata");
		product.setStockRemaining(20);

		productRepo.insertProduct(product);
	}

	@Test
	void newInsertProductWithUserAndAdminTest() {

		Admin adminObj = adminRepo.selectAdmin(1);

		User userObj = userRepo.selectUser(7);

		Product product1 = new Product();

		product1.setPrice(1500);
		product1.setImage("img-3");
		product1.setDescription("Sports");
		product1.setBrand("Nike");
		product1.setStockRemaining(20);
		product1.setProductAdminId(adminObj);
		product1.setProductUserId(userObj);

		productRepo.insertProduct(product1);

	}

	@Test
	void selectProductTest() {

		Product product = productRepo.selectProduct(31);

		System.out.println("------------------------------------");

		System.out.println("Product prodId     :" + product.getProductId());
		System.out.println("Product price      :" + product.getPrice());
		System.out.println("Product image      :" + product.getImage());
		System.out.println("Product desc       :" + product.getDescription());
		System.out.println("Product brand      :" + product.getBrand());
		System.out.println("Product stock_rem. :" + product.getStockRemaining());

		System.out.println("------------------------------------");

	}

	@Test
	void selectAllProductsTest() {
		List<Product> productList;
		productList = productRepo.selectProducts();
		System.out.println("------------------------------------");

		for (Product product : productList) {
			System.out.println("Product prodId     :" + product.getProductId());
			System.out.println("Product price      :" + product.getPrice());
			System.out.println("Product image      :" + product.getImage());
			System.out.println("Product desc       :" + product.getDescription());
			System.out.println("Product brand      :" + product.getBrand());
			System.out.println("Product stock_rem. :" + product.getStockRemaining());
			System.out.println("Product userId     :" + product.getProductUserId());
			System.out.println("------------------------------------");

		}
	}

	@Test
	void deleteProductTest() {
		Product product = new Product();

		productRepo.deleteProduct(11);

	}

	@Test
	void updateOrderTest() {

		Product product = productRepo.selectProduct(12);

		product.setStockRemaining(40);

		productRepo.merge(product);

	}

}
