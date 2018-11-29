package com.mtc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mtc.app.dao.IProductDAO;
import com.mtc.app.dao.ProductDAOImpl;
import com.mtc.entity.Order;
import com.mtc.entity.Product;

@Service
public class ProductService implements IProductService {

	@Autowired
	private IProductDAO productDAO;

	@Override
	public void addProduct(Product product) 
	{
		productDAO.addProduct(product);
	}
	
	@Override
	public void getProductById(int id)
	{
		Product product= productDAO.findById(id);
		System.out.println(product);
	}
	
	@Override
	public boolean processOrder(Order order) 
	{
		Product product = productDAO.findById(order.getProductId());
		
		if (order.getOrderQuantity() <= product.getQuantity())
		{
			System.out.println("quantity of product before the order is placed is "+product.getQuantity());
			int updateResult= productDAO.updateQuantity(product.getId(),(product.getQuantity()-order.getOrderQuantity()));
			if (updateResult==1)
			{
				System.out.println("order is processed successfully");
				Product updatedProduct = productDAO.findById(order.getProductId());
				System.out.println("Product quantity after order is placed " +updatedProduct.getQuantity());
				
				//storing order details in database
				int orderPlacementResult = productDAO.placeOrder(order);
				if(orderPlacementResult == 1)
				{
					System.out.println("order has been added to the list successfully");
				}
				
				return true;
			}
		}
		
		System.out.println("order could not be processed");
		return false; 
	}
		 
	@Override
	public void printProducts() {
		List<Product> products = productDAO.getProducts();
		
		for (Product prod : products) {
			System.out.println(prod);
		}
	}

	public IProductDAO getProductDAO() {
		return productDAO;
	}

	public void setProductDAO(IProductDAO productDAO) {
		this.productDAO = productDAO;
	}


}
