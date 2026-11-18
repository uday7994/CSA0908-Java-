import java.util.*;
public class Main {
 static void withdraw(String raw, double balance) {
  try {
   int amount=Integer.parseInt(raw);
   if(amount<=0) throw new IllegalArgumentException("Amount must be positive");
   if(amount>balance) throw new IllegalStateException("Insufficient balance");
   System.out.println("Cash dispensed: "+amount);
  } catch(NumberFormatException e) { System.out.println("Input error: enter a number"); }
    catch(IllegalArgumentException | IllegalStateException e) { System.out.println("Withdrawal failed: "+e.getMessage()); }
    finally { System.out.println("ATM session closed"); }
 }
 public static void main(String[] args) {
  System.out.println("Valid request:"); withdraw("500",2000);
  System.out.println("\\nInvalid text:"); withdraw("abc",2000);
  System.out.println("\\nNegative amount:"); withdraw("-20",2000);
  System.out.println("\\nOver balance:"); withdraw("3000",2000);
 }
}
