package com.gl.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.stereotype.Service;



@Service
public class SimcardService {

    // Insert new simcard
    public boolean addSimcard(String company, String planName) {
        try {
            String url = "jdbc:mysql://localhost:3306/wipro_2025_java_web";
            String username = "root";
            String password = "Ashu@0812";

            SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
            dataSource.setDriver(new com.mysql.cj.jdbc.Driver());
            dataSource.setUrl(url);
            dataSource.setUsername(username);
            dataSource.setPassword(password);

            JdbcTemplate template = new JdbcTemplate(dataSource);

            String insertSql = "INSERT INTO simcard(company, planName) VALUES (?, ?)";
            template.update(insertSql, company, planName);

            return true;
        } catch (Exception ex) {
            System.out.println("Error inserting simcard: " + ex.getMessage());
            return false;
        }
    }

    // Get all simcards
    public List<Simcard> getAllSimcards() {
        try {
            String url = "jdbc:mysql://localhost:3306/wipro_2025_java_web";
            String username = "root";
            String password = "Ashu@0812";

            SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
            dataSource.setDriver(new com.mysql.cj.jdbc.Driver());
            dataSource.setUrl(url);
            dataSource.setUsername(username);
            dataSource.setPassword(password);

            JdbcTemplate template = new JdbcTemplate(dataSource);

            String selectSql = "SELECT * FROM simcard";

            return template.query(selectSql, new RowMapper<Simcard>() {
                @Override
                public Simcard mapRow(ResultSet rs, int rowNum) throws SQLException {
                    Simcard sim = new Simcard();
                    sim.setId(rs.getInt("id"));
                    sim.setCompany(rs.getString("company"));
                    sim.setPlanName(rs.getString("planName"));
                    return sim;
                }
            });
        } catch (Exception ex) {
            System.out.println("Error fetching simcards: " + ex.getMessage());
            return null;
        }
    }
}
    