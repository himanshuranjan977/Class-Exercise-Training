package com.gl.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class File4 {

    @SuppressWarnings({"ConvertToTryWithResources", "CallToPrintStackTrace", "UseSpecificCatch"})
    public static void main(String[] args) {


        /*
         * To print the data from my sql server database to java file
         * 
         */

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
            String selectSql = "select * from course";
            PreparedStatement ps = connection.prepareStatement(selectSql);
            
            //execute the query
            ResultSet rs =ps.executeQuery();
            while(rs.next()){
                //System.out.println("Name : " + rs.getNString("name"));
                //System.out.println("Hrs : " + rs.getInt("duration"));
                System.out.println("name : " +rs.getNString(2));
                System.out.println("Hrs : " +rs.getInt(3));
            }
            System.out.println(rs);
            System.out.println("Course added successfuly");
            ps.close();
            connection.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    
    }

}
