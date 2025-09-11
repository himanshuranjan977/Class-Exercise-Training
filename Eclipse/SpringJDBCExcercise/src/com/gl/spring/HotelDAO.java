package com.gl.spring;


import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

public class HotelDAO {
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
            
            String insertSql = "INSERT INTO hotel(name, address) VALUES (?, ?)";
            template.update(insertSql, "Hotel", "Mumbai");
            template.update(insertSql, "Hotel", "Delhi");

            

            

        } catch (Exception ex) {
            System.out.println("Error in db spring: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
