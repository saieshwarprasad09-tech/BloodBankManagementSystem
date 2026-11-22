package com.bloodbank.web;
import com.bloodbank.dao.DonorDAO;import jakarta.servlet.annotation.WebServlet;import jakarta.servlet.http.*;import java.io.*;
@WebServlet("/register")
public class RegisterServlet extends HttpServlet{
 protected void doPost(HttpServletRequest q,HttpServletResponse p)throws IOException{
  try{String n=q.getParameter("fullName").trim(),e=q.getParameter("email").trim().toLowerCase(),pw=q.getParameter("password"),ph=q.getParameter("phone").trim(),g=q.getParameter("gender"),bg=q.getParameter("bloodGroup"),city=q.getParameter("city").trim();int age=Integer.parseInt(q.getParameter("age"));
   if(n.isBlank()||pw.isBlank()||ph.isBlank()||age<18||age>65){p.sendRedirect("register.jsp?error=1");return;}
   new DonorDAO().register(n,e,pw,ph,age,g,bg,city);p.sendRedirect("login.jsp?registered=1");
  }catch(Exception x){p.sendRedirect("register.jsp?error=1");}
 }
}
