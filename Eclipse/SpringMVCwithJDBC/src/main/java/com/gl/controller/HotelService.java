package com.gl.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.stereotype.Service;
@Service

public class HotelService {
	public boolean addHotel(String name, String address) {
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

            
            String insertSql = "INSERT INTO hotel(name, address) VALUES (?, ?)";
            template.update(insertSql, name, address);

            // Add success message to model
            return true;

        } 
        	catch (Exception ex) {
                System.out.println("Error in db spring: " + ex.getMessage());
                return false;
        	
           
            
        }
	}
	public List getAllHotels() {
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

            String select = "SELECT * FROM hotel";
            

            List<Hotel> hotels = template.query(select, new RowMapper<Hotel>() {
                @Override
                public Hotel mapRow(ResultSet rs, int rowNum) throws SQLException {
                    Hotel temp = new Hotel();
                    temp.setId(rs.getInt("id"));
                    temp.setName(rs.getString("name"));
                    temp.setAddress(rs.getString("address"));
                    return temp;
                }
            });
            return hotels;
		
		}catch(Exception ex) {
			System.out.println("Error in db spring : " + ex.getMessage());
			return null;
		}

	}
}
