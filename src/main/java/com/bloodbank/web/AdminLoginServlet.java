package com.bloodbank.web;
import com.bloodbank.util.DBConnection;import jakarta.servlet.ServletException;import jakarta.servlet.annotation.WebServlet;import jakarta.servlet.http.*;import java.io.*;import java.sql.*;
@WebServlet("/admin-login")
public class AdminLoginServlet extends HttpServlet{
 protected void doPost(HttpServletRequest q,HttpServletResponse p)throws ServletException,IOException{
  try(Connection c=DBConnection.getConnection();PreparedStatement s=c.prepareStatement("SELECT id FROM admins WHERE username=? AND password=?")){
   s.setString(1,q.getParameter("username"));s.setString(2,q.getParameter("password"));try(ResultSet r=s.executeQuery()){if(r.next()){q.getSession().setAttribute("admin",q.getParameter("username"));p.sendRedirect(q.getContextPath()+"/admin/dashboard.jsp");}else p.sendRedirect(q.getContextPath()+"/admin/login.jsp?error=1");}
  }catch(SQLException e){throw new ServletException(e);}
 }
}
