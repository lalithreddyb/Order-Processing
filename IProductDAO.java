package com.mtc.app.dao;

import java.util.List;

import com.mtc.entity.Order;
import com.mtc.entity.Product;

public interface IProductDAO {
	
	int placeOrder(Order order);
	void addProduct(Product product);
	Product findById(int id);
	int updateQuantity(int productID, int quantity);
	List<Product> getProducts();

}
