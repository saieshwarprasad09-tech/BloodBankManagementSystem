package com.bloodbank.web;
import com.bloodbank.dao.DonorDAO;import jakarta.servlet.ServletException;import jakarta.servlet.annotation.WebServlet;import jakarta.servlet.http.*;import java.io.*;
@WebServlet("/login")
public class LoginServlet extends HttpServlet{
 protected void doPost(HttpServletRequest q,HttpServletResponse p)throws ServletException,IOException{
  try{DonorDAO d=new DonorDAO();int id=d.login(q.getParameter("email").trim().toLowerCase(),q.getParameter("password"));if(id>0){q.getSession().setAttribute("donorId",id);q.getSession().setAttribute("donorName",d.name(id));p.sendRedirect("dashboard.jsp");}else p.sendRedirect("login.jsp?error=1");}catch(Exception e){throw new ServletException(e);}
 }
}
