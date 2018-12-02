package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class offerRide2 extends HttpServlet {

    public void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        name obj=new name();
        String name1=obj.name1();
        Connection con=null;
        
        PreparedStatement pr=null;
        try{
            String myUrl="jdbc:mysql://localhost/carpoolingproj";
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(myUrl,"root","");
            HttpSession sn;
           sn=request.getSession(false);
           sn.getAttribute("name");
            String query="select * from  tb where name=?";
            pr=con.prepareStatement(query);
            pr.setString(1,"name");
            ResultSet rs;
            rs=pr.executeQuery();
            if(rs.next())
            {
                
            }
        }
        catch(Exception e)
        {
            System.out.println("got an Exception");
            System.out.println(e.getMessage());
        }
    }

}
