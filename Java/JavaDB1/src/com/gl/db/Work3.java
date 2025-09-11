package com.gl.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Work3 {
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
            String query = "select * from animal where age >5" ;

            PreparedStatement ps = connection.prepareStatement(query);
            
            //execute the query
            ResultSet rs =ps.executeQuery();
            while(rs.next()){
                System.out.println("Name : " +rs.getNString(1));
                System.out.println("Food Habit : " +rs.getString(2));
                System.out.println("Age : " +rs.getInt(3));
                System.out.println("Color : " +rs.getString(4));
                System.out.println("Height : " +rs.getInt(5));
                System.out.println("Weight : " +rs.getInt(6));
                
            }
            
            
            ps.execute();
            System.out.println("Course added successfuly");
            ps.close();
            connection.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}