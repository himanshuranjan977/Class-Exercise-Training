package com.gl.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Work5 {
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
            String query = "delete from animal where age > 10" ;

            PreparedStatement ps = connection.prepareStatement(query);
            
            
            //execute the query
            int rowsAffected = ps.executeUpdate(); // ✅ use executeUpdate() instead of executeQuery()
            System.out.println(rowsAffected + " animal(s) deleted where age > 10");
            
            
            
            ps.execute();
            System.out.println("Course added successfuly");
            ps.close();
            connection.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
