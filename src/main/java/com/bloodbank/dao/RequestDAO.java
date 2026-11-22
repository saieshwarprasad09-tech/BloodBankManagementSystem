package com.bloodbank.dao;
import com.bloodbank.util.DBConnection;
import java.sql.*;
import java.util.*;
public class RequestDAO {
 public void create(int donor,String patient,String group,int units,String hospital,String phone,String notes)throws SQLException{
  try(Connection c=DBConnection.getConnection();PreparedStatement s=c.prepareStatement("INSERT INTO blood_requests(donor_id,patient_name,blood_group,units_needed,hospital_name,contact_phone,notes) VALUES(?,?,?,?,?,?,?)")){
   s.setInt(1,donor);s.setString(2,patient);s.setString(3,group);s.setInt(4,units);s.setString(5,hospital);s.setString(6,phone);s.setString(7,notes);s.executeUpdate();
  }
 }
 public List<Map<String,Object>> list(Integer donorId)throws SQLException{
  List<Map<String,Object>> a=new ArrayList<>();String q="SELECT r.*,d.full_name FROM blood_requests r JOIN donors d ON d.id=r.donor_id "+(donorId==null?"":"WHERE r.donor_id=? ")+"ORDER BY r.created_at DESC";
  try(Connection c=DBConnection.getConnection();PreparedStatement s=c.prepareStatement(q)){if(donorId!=null)s.setInt(1,donorId);try(ResultSet r=s.executeQuery()){while(r.next()){Map<String,Object> m=new LinkedHashMap<>();m.put("id",r.getInt("id"));m.put("donor",r.getString("full_name"));m.put("patient",r.getString("patient_name"));m.put("group",r.getString("blood_group"));m.put("units",r.getInt("units_needed"));m.put("hospital",r.getString("hospital_name"));m.put("phone",r.getString("contact_phone"));m.put("status",r.getString("status"));m.put("created",r.getTimestamp("created_at"));a.add(m);}}}return a;
 }
 public void status(int id,String st)throws SQLException{try(Connection c=DBConnection.getConnection();PreparedStatement s=c.prepareStatement("UPDATE blood_requests SET status=? WHERE id=?")){s.setString(1,st);s.setInt(2,id);s.executeUpdate();}}
}
