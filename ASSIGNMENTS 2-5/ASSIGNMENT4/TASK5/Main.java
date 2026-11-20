import java.text.*;
public class Main {
 static double rate(String currency){return currency.equals("USD")?0.012:0.011;}
 static String convert(String raw,String target){try{double amount=Double.parseDouble(raw);if(amount<0)throw new NumberFormatException();return String.format("%.2f %s",amount*rate(target),target);}catch(NumberFormatException e){return "Invalid amount";}}
 public static void main(String[] args){System.out.println("1000 INR to USD: "+convert("1000","USD"));System.out.println("500 INR to EUR: "+convert("500","EUR"));System.out.println("Bad input: "+convert("abc","USD"));System.out.println("Handler styles: frame, named inner, anonymous inner, lambda.");
 }
}
