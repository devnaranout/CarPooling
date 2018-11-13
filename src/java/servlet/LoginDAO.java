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
    
    public String checkInfo(String userName,String passW) throws ClassNotFoundException, SQLException
    {
        Connection con=null;
        PreparedStatement pr=null;
            String myUrl="jdbc:mysql://localhost/carpoolingproj";
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(myUrl,"root","");
           
            String query="select * from tbuser where username=? and password=?";
            pr=con.prepareStatement(query);
            pr.setString(1,userName);
            pr.setString(2,passW);
            ResultSet rs;
            rs=pr.executeQuery();
            if(rs.next())
            {
                return "you are logged in";
            }
           
                return "incorrect data";

            
    }
    public String addData(String username,String email,String password) throws ClassNotFoundException, SQLException
    {
        Connection con=null;
        PreparedStatement pr=null;
            String myUrl="jdbc:mysql://localhost/carpoolingproj";
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(myUrl,"root","");
           
            String query="insert into tbuser(username,email,password) values(?,?,?)";
            pr=con.prepareStatement(query);
            pr.setString(1,username);
            pr.setString(2,email);
            pr.setString(3,password);
            int rs = pr.executeUpdate();
            if(rs>0)
            {
                return "data inserted successfully";
            }
            return "data not inserted";
    }
    
    public static void main(String args[]) throws ClassNotFoundException, SQLException
    {
        LoginDAO l = new LoginDAO();
        String result = l.addData("manish", "manish@12332", "asdfasdf");
        System.out.println(result);
    }
    
}
