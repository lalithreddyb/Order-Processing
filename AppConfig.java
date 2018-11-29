package com.mtc.app.Config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@ComponentScan("com.mtc")
@Configuration
public class AppConfig {
	
	@Bean("basicDataSource")
	public BasicDataSource getBasicDataSource()
	{
		
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
		basicDataSource.setUrl("jdbc:mysql://localhost:3306");
		basicDataSource.setUsername("root");
		basicDataSource.setPassword("lalith@143");
		basicDataSource.setInitialSize(5);
		basicDataSource.setMaxTotal(10);
		
		return basicDataSource;
		
	}
	
	@Bean("jdbcTemplate")
	public JdbcTemplate getJDBCTemplate()
	{
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		
		jdbcTemplate.setDataSource(getBasicDataSource());
		
		return jdbcTemplate;
	}
	
	}
