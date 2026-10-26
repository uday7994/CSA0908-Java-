interface Chargeable {double chargingFee(int kWh);}
abstract class Vehicle {private final String reg;protected Vehicle(String r){reg=r;}public String getRegNo(){return reg;}
protected abstract double ratePerHour();public double calculateFee(int minutes){int hours=(minutes+59)/60;return hours*ratePerHour();}
public boolean equals(Object o){return o instanceof Vehicle && reg.equals(((Vehicle)o).reg);}public int hashCode(){return reg.hashCode();}}
class TwoWheeler extends Vehicle {TwoWheeler(String r){super(r);}protected double ratePerHour(){return 10;}}
class Car extends Vehicle {Car(String r){super(r);}protected double ratePerHour(){return 30;}}
class ElectricCar extends Car implements Chargeable {ElectricCar(String r){super(r);}public double chargingFee(int kWh){return kWh*12.0;}}
public class FeeDemo {public static void main(String[] a){Vehicle[] parked={new TwoWheeler("TN01A1"),new Car("TN02B2"),new ElectricCar("TN03C3")};
for(Vehicle v:parked){double fee=v.calculateFee(130);if(v instanceof Chargeable)fee+=((Chargeable)v).chargingFee(10);
System.out.println(v.getClass().getSimpleName()+" "+v.getRegNo()+" -> Rs "+fee);}
System.out.println(new Car("TN02B2").equals(new ElectricCar("TN02B2")));}}