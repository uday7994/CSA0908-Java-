import java.sql.*;
public class Main {
 static void transfer(Connection c,int from,int to,int amount)throws SQLException{boolean old=c.getAutoCommit();c.setAutoCommit(false);try(PreparedStatement debit=c.prepareStatement("UPDATE wallet SET balance=balance-? WHERE id=?");PreparedStatement credit=c.prepareStatement("UPDATE wallet SET balance=balance+? WHERE id=?")){debit.setInt(1,amount);debit.setInt(2,from);credit.setInt(1,amount);credit.setInt(2,to);if(debit.executeUpdate()!=1||credit.executeUpdate()!=1)throw new SQLException("Wallet not found");c.commit();}catch(SQLException e){c.rollback();throw e;}finally{c.setAutoCommit(old);}}
 public static void main(String[] args){String sql="SELECT * FROM users WHERE id=? AND pwd=?";System.out.println("Safe login SQL: "+sql);System.out.println("Wallet transfer: debit + credit are committed together or rolled back.");}
}
