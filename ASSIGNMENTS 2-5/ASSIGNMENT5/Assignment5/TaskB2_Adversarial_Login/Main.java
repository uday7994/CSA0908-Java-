public class Main {
 static boolean unsafeLogin(String id,String pwd){String sql="SELECT * FROM users WHERE id='"+id+"' AND pwd='"+pwd+"'";System.out.println("Unsafe SQL: "+sql);return pwd.equals("' OR '1'='1");}
 static String safeSql(){return "SELECT * FROM users WHERE id=? AND pwd=?";}
 public static void main(String[] args){String attack="' OR '1'='1";System.out.println("Adversarial password accepted by unsafe logic: "+unsafeLogin("admin",attack));System.out.println("PreparedStatement query: "+safeSql());System.out.println("With placeholders, attack text is treated as data, not SQL.");}
}
