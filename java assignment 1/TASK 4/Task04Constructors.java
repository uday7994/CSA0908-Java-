class ParkingTicket { private final int number; private final String reg;
ParkingTicket(int number){this(number,"UNKNOWN");} ParkingTicket(int number,String reg){this.number=number;this.reg=reg;}
public String toString(){return "Ticket #"+number+" for "+reg;}}
public class Task04Constructors {public static void main(String[] a){
System.out.println(new ParkingTicket(101));System.out.println(new ParkingTicket(102,"TN01AB1111"));
System.out.println("Overloaded constructors use this() to share initialization.");}}