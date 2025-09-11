package com.gl.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class File8 {
    
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

        Connection connection = null;
        try{
            //load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //first step: connecting to the database
            connection = DriverManager.getConnection(url, username, password);
            //very important to start a transaction logic
            connection.setAutoCommit(false);
            //prepare the sql query
            String insertSql = "insert into course values (?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(insertSql);
            //supply the values for the query
            ps.setInt(1, 10);
            ps.setString(2, "course 1");
            ps.setInt(3, 30);
            //execute the query
            ps.execute();
            System.err.println("Course 1 inserted");
            //supply the values for the query
            ps.setInt(1, 11);
            ps.setString(2, "course 2");
            ps.setInt(3, 3);
            //execute the query
            ps.execute();
            System.err.println("Course 2 inserted");
            //supply the values for the query
            ps.setInt(1, 12);
            ps.setString(2, "course 3");
            ps.setInt(3, 3);//exception
            //execute the query
            ps.execute();
            System.err.println("Course 3 inserted");
            ps.setInt(1, 13);
            ps.setString(2, "course 4");
            ps.setInt(3, 3);
            //execute the query
            ps.execute();
            System.err.println("Course 4 inserted");
            ps.setInt(1, 14);
            ps.setString(2, "course 5");
            ps.setInt(3, 3);
            //execute the query
            ps.execute();
            System.err.println("Course 5 inserted");
            System.out.println("Course added successfuly");
            
            connection.commit();
            ps.close();
            connection.close();
        }catch(Exception e){
            try {
                if(connection != null){
                    System.out.println("rollback happening");
                    connection.rollback();
                }
            
            } catch (SQLException ex) {
                System.out.println("Error during rollback");
                ex.printStackTrace();

            
            }
            e.printStackTrace();
        }
        finally{
            if(connection != null){
                try{
                    connection.setAutoCommit(true);
                    connection.close();
                } catch (SQLException ex){
                    System.out.println("finally failed");
                }
            }
        }
    }
}
