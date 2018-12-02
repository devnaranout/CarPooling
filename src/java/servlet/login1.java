package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class login1 extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        String email=request.getParameter("email");
        String passW=request.getParameter("psw");
        
       
        LoginDAO l = new LoginDAO();
        try {
           String result = l.checkInfo(email, passW);
           if(result.equals("you are logged in"))
               
           response.sendRedirect("findRide.html");
           else
           {
               response.sendRedirect("login1.html");
           }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(login1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(login1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

