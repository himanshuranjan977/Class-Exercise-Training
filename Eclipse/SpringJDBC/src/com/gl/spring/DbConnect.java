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
            String insert = "INSERT INTO product(name, price, discount, unit) VALUES(?, ?, ?, ?)";
            int rowsInserted = template.update(insert, "Water", 100, 10, 3);
            System.out.println("Rows inserted: " + rowsInserted);

            // ✅ Update product (e.g., update price where name = Watermelon)
            String update = "UPDATE product SET price = ? WHERE name = ?";
            int rowsUpdated = template.update(update, 110, "Water");
            System.out.println("Rows updated: " + rowsUpdated);

            // ✅ Delete product (e.g., delete product by name)
            //String delete = "DELETE FROM product WHERE name = ?";
            //int rowsDeleted = template.update(delete, "Papa");
            //System.out.println("Rows deleted: " + rowsDeleted);
            
            String delete = "delete from product where id = ?";
            int rowsDeleted=template.update(delete, 2);
            System.out.println("Rows deleted: " + rowsDeleted);

        } catch (Exception ex) {
            System.out.println("Error in db spring: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
