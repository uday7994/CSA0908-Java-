import java.util.*;
class FeeService {
 String pay(String reg,double amount){if(reg.isBlank())throw new IllegalArgumentException("Register number required");if(amount<=0)throw new IllegalArgumentException("Amount must be positive");return "Payment successful for "+reg+": Rs."+amount;}
}
public class Main {
 public static void main(String[] args){FeeService s=new FeeService();
  for(String[] x:new String[][]{{"192411203","2500"},{"","2500"},{"192411203","-1"}})
   try{System.out.println(s.pay(x[0],Double.parseDouble(x[1])));}catch(Exception e){System.out.println("Payment error: "+e.getMessage());}
 }
}
