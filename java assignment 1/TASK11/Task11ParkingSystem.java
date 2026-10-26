import java.util.*;
abstract class ParkedVehicle {private final String reg;ParkedVehicle(String r){if(r==null||r.isBlank())throw new IllegalArgumentException("Registration required");reg=r;}
String getReg(){return reg;}abstract double rate();}
class ParkedBike extends ParkedVehicle {ParkedBike(String r){super(r);}double rate(){return 10;}}
class ParkedCar extends ParkedVehicle {ParkedCar(String r){super(r);}double rate(){return 30;}}
class ActiveTicket {ParkedVehicle v;int f,s;ActiveTicket(ParkedVehicle v,int f,int s){this.v=v;this.f=f;this.s=s;}}
class SmartParking {String[][] slots;Map<String,ActiveTicket> active=new LinkedHashMap<>();
SmartParking(int[] c){slots=new String[c.length][];for(int i=0;i<c.length;i++)slots[i]=new String[c[i]];}
boolean enter(ParkedVehicle v){if(active.containsKey(v.getReg())){System.out.println("Duplicate registration rejected: "+v.getReg());return false;}
for(int f=0;f<slots.length;f++)for(int s=0;s<slots[f].length;s++)if(slots[f][s]==null){slots[f][s]=v.getReg();active.put(v.getReg(),new ActiveTicket(v,f,s));System.out.println("Parked "+v.getReg()+" at ["+f+", "+s+"]");return true;}
System.out.println("Parking full: "+v.getReg());return false;}
double exit(String r,int minutes){ActiveTicket t=active.remove(r);if(t==null){System.out.println("No active ticket for "+r);return -1;}
slots[t.f][t.s]=null;double fee=((minutes+59)/60)*t.v.rate();System.out.println("Exited "+r+"; duration="+minutes+" min; fee=Rs "+fee);return fee;}}
public class Task11ParkingSystem {public static void main(String[] a){SmartParking p=new SmartParking(new int[]{1,1});
p.enter(new ParkedBike("TN01A1"));p.enter(new ParkedCar("TN02B2"));p.enter(new ParkedCar("TN01A1"));p.enter(new ParkedBike("TN03C3"));
p.exit("TN01A1",0);p.exit("TN99Z9",30);p.enter(new ParkedCar("TN03C3"));}}