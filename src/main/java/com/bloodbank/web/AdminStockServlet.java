package com.bloodbank.web;
import com.bloodbank.dao.BloodDAO;import jakarta.servlet.ServletException;import jakarta.servlet.annotation.WebServlet;import jakarta.servlet.http.*;import java.io.*;
@WebServlet("/admin-stock")
public class AdminStockServlet extends HttpServlet{protected void doPost(HttpServletRequest q,HttpServletResponse p)throws ServletException,IOException{
 if(q.getSession(false)==null||q.getSession(false).getAttribute("admin")==null){p.sendRedirect(q.getContextPath()+"/admin/login.jsp");return;}
 try{int u=Integer.parseInt(q.getParameter("units"));if(u<0)throw new IllegalArgumentException();new BloodDAO().save(q.getParameter("bloodGroup"),u);p.sendRedirect(q.getContextPath()+"/admin/dashboard.jsp?stock=updated");}catch(Exception e){throw new ServletException(e);}
}}
