package com.gl.spring;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

public class DBSelect {
    public static void main(String[] args) {
        try {
            String url = "jdbc:mysql://localhost:3306/wipro_2025_java_web";
            String username = "root";
            String password = "Ashu@0812";

            // Create DataSource
            SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
            dataSource.setDriver(new com.mysql.cj.jdbc.Driver());
            dataSource.setUrl(url);
            dataSource.setUsername(username);
            dataSource.setPassword(password);

            // Create JdbcTemplate
            JdbcTemplate template = new JdbcTemplate(dataSource);

            // SQL SELECT query
            String select = "SELECT * FROM book";

            // Execute query using RowMapper
            List<Product> products = template.query(select, new RowMapper<Product>() {
                @Override
                public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
                    try {
                    	Product temp = new Product();
                        temp.setId(rs.getInt("id"));
                        temp.setName(rs.getString("name"));
                        temp.setAuthor(rs.getString("author"));
                        temp.setPrice(rs.getInt("price"));
                        
                        return temp;
                    	
                    }catch(Exception ex) {
                    	System.out.println("Error in road Mapper " + ex.getMessage());
                    	return null;
                    	
                    }
                }
            });

            // Print all products
            for (int i =0;i<products.size();i++) {
            	Product temp =(Product) products.get(i);
                System.out.println("ID : " + temp. getId() +", Name : " +temp.getName()+", Author : " + temp.getAuthor() + ", Price :" +temp.getPrice());
            }

        } catch (Exception ex) {
            System.out.println("Error in db spring: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
