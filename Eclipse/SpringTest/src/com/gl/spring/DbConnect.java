package com.gl.spring;



import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

public class DbConnect {
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

            // ✅ Insert a product
            String insert = "INSERT INTO book(id, name, author, price) VALUES(?, ?, ?, ?)";
            int rowsInserted = template.update(insert, 4, "The Alchemist", "Paulo Coelho", 400);
            System.out.println("Rows inserted: " + rowsInserted);

            
        } catch (Exception ex) {
            System.out.println("Error in db spring: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}

