package com.gl.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Work1 {
    
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
            String insertSql = "insert into animal values (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(insertSql);
            //supply the values for the query
           //1
           /*  ps.setString(1, "Lion");
            ps.setString(2, "Carnivouros");
            ps.setInt(3, 5);
            ps.setString(4, "Yellow");
            ps.setInt(5, 5);
            ps.setInt(6, 50);*/

            //2
            //ps.setInt(1, 2);
            ps.setString(1, "Dog");
            ps.setString(2, "Omnivourous");
            ps.setInt(3, 11);
            ps.setString(4, "Grey");
            ps.setInt(5, 6);
            ps.setInt(6, 23);
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
