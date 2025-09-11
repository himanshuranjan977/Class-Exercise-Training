package com.gl.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
public class File5 {
    @SuppressWarnings({"ConvertToTryWithResources", "CallToPrintStackTrace", "UseSpecificCatch"})
   public static void main(String[] args) {
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
            String insertSql = "insert into planet values (?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(insertSql);
            //supply the values for the query
            ps.setInt(1, 2);
            ps.setString(2, "Saturn");
            ps.setString(3, "Pale gold");
            ps.execute();
            System.out.println("Course added successfuly");
            ps.close();
            connection.close();
        }catch(Exception e){
            e.printStackTrace();
        }
       
   }

}
