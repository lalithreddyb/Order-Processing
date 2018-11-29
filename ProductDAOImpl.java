package com.mtc.app.dao;

import java.sql.ResultSet;
import java.util.List;

import javax.swing.tree.RowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.mtc.entity.Order;
import com.mtc.entity.Product;
import com.mtc.service.IProductService;

@Repository
public class ProductDAOImpl implements IProductDAO{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private ProductRowMapper productRowMapper;
	
	private String insertQuery = "insert into test.product(id,name,price,description,quantity) values(?,?,?,?,?)";
	private String selectQuery = "select * from test.product where id=?";
	private String selectAllQuery = "select * from test.product";
	private String updateQuery = "update test.product set quantity=? where id=?";
	private String placeOrder = "insert into test.order (orderID,productID,orderQuantity,Comments) values(?,?,?,?)";
	
	@Override
	public void addProduct(Product product)
	{
		int result = jdbcTemplate.update(selectQuery,product.getId(),product.getName(),product.getPrice(),product.getDescription(),product.getQuantity());
		if(result == 1)
		{
			System.out.println("product has been added successfully");
		}
	}
	
	@Override
	public Product findById(int id)
	{
	
		Product product = jdbcTemplate.queryForObject(selectQuery, productRowMapper, id);
		
		return product;
	}

	@Override
	public int updateQuantity(int productID, int updatedQuantity) 
	{
		
		int result = jdbcTemplate.update(updateQuery, updatedQuantity, productID);
		
		return result;
	}

	@Override
	public List<Product> getProducts()
	{
		return jdbcTemplate.query(selectAllQuery, productRowMapper);
	}

	@Override
	public int placeOrder(Order order) {
		
		return jdbcTemplate.update(placeOrder,order.getId(),order.getProductId(),order.getOrderQuantity(),order.getComments());
		
	}
	
}
