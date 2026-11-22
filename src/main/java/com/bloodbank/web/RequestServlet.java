package com.bloodbank.web;
import com.bloodbank.dao.RequestDAO;import jakarta.servlet.ServletException;import jakarta.servlet.annotation.WebServlet;import jakarta.servlet.http.*;import java.io.*;
@WebServlet("/request-blood")
public class RequestServlet extends HttpServlet{
 protected void doPost(HttpServletRequest q,HttpServletResponse p)throws ServletException,IOException{
  HttpSession s=q.getSession(false);if(s==null||s.getAttribute("donorId")==null){p.sendRedirect("login.jsp");return;}
  try{String patient=q.getParameter("patientName").trim(),bg=q.getParameter("bloodGroup"),hospital=q.getParameter("hospital").trim(),phone=q.getParameter("phone").trim(),notes=q.getParameter("notes");int units=Integer.parseInt(q.getParameter("units"));
   if(patient.isBlank()||hospital.isBlank()||phone.isBlank()||units<1||units>20){p.sendRedirect("request-blood.jsp?error=1");return;}
   new RequestDAO().create((Integer)s.getAttribute("donorId"),patient,bg,units,hospital,phone,notes);p.sendRedirect("my-requests.jsp?submitted=1");
  }catch(Exception e){throw new ServletException(e);}
 }
}
