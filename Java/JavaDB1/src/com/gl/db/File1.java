package com.gl.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
public class File1 {
    
    @SuppressWarnings({"ConvertToTryWithResources", "CallToPrintStackTrace", "UseSpecificCatch"})
    public static void main(String args[]){
        //java and mysql server all are runingin same machine -> localhost
        //java and mysql running on different machine -> ip address
        //https://www.google.com -> web server
        //ftp -> file server
        //jdbc:mysql:// -> mysql database server
        //where is the db
        String url = "jdbc:mysql://localhost:3306/learn_fk";
        //what is the username
        String username = "root";
        //what is the password
        String password = "Ashu@0812";
        try{
            //load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //first step: connecting to the database
            Connection connection = DriverManager.getConnection(url, username, password);
            //prepare the sql query
            String insertSql = "insert into course values (?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(insertSql);
            //supply the values for the query
            ps.setInt(1, 9);
            ps.setString(2, "RT");
            ps.setInt(3, 30);
            //execute the query
            ps.execute();
            //supply the values for the query
            ps.setInt(1, 6);
            ps.setString(2, "JS");
            ps.setInt(3, 3);
            //execute the query
            ps.execute();
            //supply the values for the query
            ps.setInt(1, 7);
            ps.setString(2, "CSS");
            ps.setInt(3, 20);
            //execute the query
            ps.execute();
            System.out.println("Course added successfuly");
            ps.close();
            connection.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}