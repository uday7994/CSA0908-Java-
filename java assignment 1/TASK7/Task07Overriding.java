class FeeVehicle {private final String reg; FeeVehicle(String r){reg=r;} double calculateFee(int h){return h*20.0;}
public String toString(){return getClass().getSimpleName()+"("+reg+")";}
public boolean equals(Object o){return o instanceof FeeVehicle && reg.equals(((FeeVehicle)o).reg);}
public int hashCode(){return reg.hashCode();}}
class FeeCar extends FeeVehicle {FeeCar(String r){super(r);}@Override double calculateFee(int h){return h*30.0;}}
public class Task07Overriding {public static void main(String[] a){FeeVehicle v=new FeeVehicle("TN01A1");FeeCar c=new FeeCar("TN02B2");
System.out.println(v+" -> Rs "+v.calculateFee(2));System.out.println(c+" -> Rs "+c.calculateFee(2));
System.out.println("Same registration means equal: "+new FeeVehicle("TN01A1").equals(new FeeVehicle("TN01A1")));}}