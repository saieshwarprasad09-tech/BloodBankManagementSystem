package com.bloodbank.dao;
import com.bloodbank.util.DBConnection;
import java.sql.*;
public class DonorDAO {
 public boolean register(String n,String e,String p,String ph,int age,String g,String bg,String city)throws SQLException{
  try(Connection c=DBConnection.getConnection();PreparedStatement s=c.prepareStatement("INSERT INTO donors(full_name,email,password,phone,age,gender,blood_group,city) VALUES(?,?,?,?,?,?,?,?)")){
   s.setString(1,n);s.setString(2,e);s.setString(3,p);s.setString(4,ph);s.setInt(5,age);s.setString(6,g);s.setString(7,bg);s.setString(8,city);return s.executeUpdate()==1;
  }
 }
 public int login(String e,String p)throws SQLException{
  try(Connection c=DBConnection.getConnection();PreparedStatement s=c.prepareStatement("SELECT id FROM donors WHERE email=? AND password=?")){
   s.setString(1,e);s.setString(2,p);try(ResultSet r=s.executeQuery()){return r.next()?r.getInt("id"):-1;}
  }
 }
 public String name(int id)throws SQLException{
  try(Connection c=DBConnection.getConnection();PreparedStatement s=c.prepareStatement("SELECT full_name FROM donors WHERE id=?")){
   s.setInt(1,id);try(ResultSet r=s.executeQuery()){return r.next()?r.getString(1):"Donor";}
  }
 }
}
