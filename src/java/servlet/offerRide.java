/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class offerRide extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        String name=request.getParameter("name");
        String car=request.getParameter("car");
        String dep=request.getParameter("dep");
        String arr=request.getParameter("arr");
        String stop=request.getParameter("stop");
        String depd=request.getParameter("depd");
        String time=request.getParameter("time");
        
        LoginDAO l = new LoginDAO();
        try {
           String result = l.add(name, car, dep, arr, stop, depd, time);
           if(result.equals("your data has been registered"))
           response.sendRedirect("offerRide2.html");
           else
               response.sendRedirect("offerRide.java");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
