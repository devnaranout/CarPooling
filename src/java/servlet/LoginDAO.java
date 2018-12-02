/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author HP
 */
public class LoginDAO {
    
    public String checkInfo(String email,String passW) throws ClassNotFoundException, SQLException
    {
        Connection con=null;
        PreparedStatement pr=null;
            String myUrl="jdbc:mysql://localhost/carpoolingproj";
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(myUrl,"root","");
            
            
           
            String query="select * from tbuser where email=? and password=?";
            pr=con.prepareStatement(query);
            pr.setString(1,email);
            pr.setString(2,passW);
            
            ResultSet rs;
            rs=pr.executeQuery();
            if(rs.next())
            {
                return "you are logged in";
            }
           
                return "incorrect data";

            
    }
    public String check(String dep,String arr,String depd) throws ClassNotFoundException, SQLException
    {
        Connection con=null;
        PreparedStatement pr=null;
            String myUrl="jdbc:mysql://localhost/carpoolingproj";
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(myUrl,"root","");
           
            String query="select * from tb where dep=? and arr=? and depd=?";
            pr=con.prepareStatement(query);
            pr.setString(1,dep);
            pr.setString(2,arr);
            pr.setString(3, depd);
            ResultSet rs;
            rs=pr.executeQuery();
            if(rs.next())
            {
                return "ride available";
            }
           
                return "ride not available";

            
    }
    public String addData(String username,String email,String mobNo,String password) throws ClassNotFoundException, SQLException
    {
        Connection con=null;
        PreparedStatement pr=null;
            String myUrl="jdbc:mysql://localhost/carpoolingproj";
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(myUrl,"root","");
            
           
            String query="insert into tbuser(username,email,mobNo,password) values(?,?,?,?)";
            pr=con.prepareStatement(query);
            pr.setString(1,username);
            pr.setString(2,email);
            pr.setString(3,mobNo);
            pr.setString(4,password);
            ResultSet rs;
            rs=pr.executeQuery();
            if(rs.next())
            {
                return "data inserted successfully";
            }
            return "data not inserted";
    }
    public String add(String name,String car,String dep,String arr,String stop,String depd,String time) throws ClassNotFoundException, SQLException
    {
        Connection con=null;
        PreparedStatement pr=null;
            String myUrl="jdbc:mysql://localhost/carpoolingproj";
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(myUrl,"root","");
            
           
            String query="insert into tb(name,car,dep,arr,stop,depd,time) values(?,?,?,?,?,?,?)";
            pr=con.prepareStatement(query);
            pr.setString(1,name);
            pr.setString(2,car);
            pr.setString(3,dep);
            pr.setString(4,arr);
            pr.setString(5,stop);
            pr.setString(6,depd);
            pr.setString(7,time);
            ResultSet rs;
            rs=pr.executeQuery();
            if(rs.next())
            {
                return "your data has been registered";
            }
            return "data not registered";
    }
    
    
}
