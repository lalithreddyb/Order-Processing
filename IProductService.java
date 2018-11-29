package com.mtc.service;

import com.mtc.entity.Order;
import com.mtc.entity.Product;

public interface IProductService{
	
	void getProductById(int id);
	void addProduct(Product product);
	boolean processOrder(Order order);
	void printProducts();

}
