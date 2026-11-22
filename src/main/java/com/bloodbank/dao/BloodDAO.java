package com.bloodbank.dao;
import com.bloodbank.util.DBConnection;
import java.sql.*;
import java.util.*;
public class BloodDAO {
 public List<Map<String,Object>> stock()throws SQLException{
  List<Map<String,Object>> a=new ArrayList<>();
  try(Connection c=DBConnection.getConnection();PreparedStatement s=c.prepareStatement("SELECT blood_group,units,updated_at FROM blood_stock ORDER BY blood_group");ResultSet r=s.executeQuery()){
   while(r.next()){Map<String,Object> m=new LinkedHashMap<>();m.put("group",r.getString(1));m.put("units",r.getInt(2));m.put("updated",r.getTimestamp(3));a.add(m);}
  }return a;
 }
 public void save(String g,int u)throws SQLException{
  try(Connection c=DBConnection.getConnection();PreparedStatement s=c.prepareStatement("INSERT INTO blood_stock(blood_group,units) VALUES(?,?) ON DUPLICATE KEY UPDATE units=VALUES(units)")){s.setString(1,g);s.setInt(2,u);s.executeUpdate();}
 }
}
