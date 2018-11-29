package com.mtc.app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.swing.tree.TreePath;
import com.mtc.entity.Product;

@Component
public class ProductRowMapper implements org.springframework.jdbc.core.RowMapper<Product>{

	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		
		Product product = new Product();
		
		product.setId(rs.getInt("id"));
		product.setName(rs.getString("name"));;
		product.setPrice(rs.getFloat("price"));
		product.setQuantity(rs.getInt("quantity"));
		product.setDescription(rs.getString("description"));
		
		return product;
	}

	
	}

