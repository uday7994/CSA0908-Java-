import java.sql.*;import java.util.*;
public class Main {
 static int loadAll(Connection con,List<String[]> rows)throws SQLException{
  String sql="INSERT INTO bus_pass(pass_id,reg_no,name,route_no,amount) VALUES(?,?,?,?,?)";
  boolean old=con.getAutoCommit();con.setAutoCommit(false);int n=0;
  try(PreparedStatement ps=con.prepareStatement(sql)){
   for(String[] p:rows){ps.setString(1,p[0]);ps.setString(2,p[1]);ps.setString(3,p[2]);ps.setInt(4,Integer.parseInt(p[3]));ps.setDouble(5,Double.parseDouble(p[4]));ps.addBatch();n++;if(n%1000==0)ps.executeBatch();}
   ps.executeBatch();con.commit();return n;
  }catch(SQLException|RuntimeException e){con.rollback();throw e;}finally{con.setAutoCommit(old);}
 }
 public static void main(String[] args){System.out.println("Batch loader ready: batches of 1000 inside one transaction.");System.out.println("Requires a configured JDBC Connection and bus_pass table.");}
}
