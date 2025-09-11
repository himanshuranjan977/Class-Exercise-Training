package com.gl.spring;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

public class HotelDAOTest {
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

            String select = "SELECT * FROM hotel";
            List<Hotel> hotels = template.query(select, new RowMapper<Hotel>() {
                @Override
                public Hotel mapRow(ResultSet rs, int rowNum) throws SQLException {
                    try {
                        Hotel temp = new Hotel();
                        temp.setId(rs.getInt("id"));
                        temp.setName(rs.getString("name"));
                        temp.setAddress(rs.getString("address"));
                        return temp;
                    } catch (Exception ex) {
                        System.out.println("Error in RowMapper: " + ex.getMessage());
                        return null;
                    }
                }
            });

            // Print all hotels
            for (Hotel h : hotels) {
                System.out.println("Id: " + h.getId() +
                                   " | Name: " + h.getName() +
                                   " | Address: " + h.getAddress());
            }


        } catch (Exception ex) {
            System.out.println("Error in db spring: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}

