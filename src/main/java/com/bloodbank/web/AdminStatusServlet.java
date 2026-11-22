package com.bloodbank.web;
import com.bloodbank.dao.RequestDAO;import jakarta.servlet.ServletException;import jakarta.servlet.annotation.WebServlet;import jakarta.servlet.http.*;import java.io.*;
@WebServlet("/admin-status")
public class AdminStatusServlet extends HttpServlet{protected void doPost(HttpServletRequest q,HttpServletResponse p)throws ServletException,IOException{
 if(q.getSession(false)==null||q.getSession(false).getAttribute("admin")==null){p.sendRedirect(q.getContextPath()+"/admin/login.jsp");return;}
 try{String st=q.getParameter("status");if(!st.equals("Pending")&&!st.equals("Approved")&&!st.equals("Rejected"))throw new IllegalArgumentException();new RequestDAO().status(Integer.parseInt(q.getParameter("id")),st);p.sendRedirect(q.getContextPath()+"/admin/dashboard.jsp?updated=1");}catch(Exception e){throw new ServletException(e);}
}}
