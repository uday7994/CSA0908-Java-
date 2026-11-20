import java.sql.*;
public class Main {
 static void printMetadata(Connection c)throws SQLException{DatabaseMetaData m=c.getMetaData();System.out.println("Database: "+m.getDatabaseProductName());System.out.println("Driver: "+m.getDriverName()+" "+m.getDriverVersion());try(ResultSet rs=m.getTables(null,null,"%",new String[]{"TABLE"})){while(rs.next())System.out.println("Table: "+rs.getString("TABLE_NAME"));}}
 public static void main(String[] args){System.out.println("Migration plan: validate text records, batch insert, commit once; report invalid rows.");System.out.println("Production choice: shared relational database for concurrent campus counters.");System.out.println("Connect a JDBC driver and database to run printMetadata(Connection).");}
}
