class TicketCounter {private static int next=1000; static int issue(){return next++;}}
public class Task05StaticMembers {public static void main(String[] a){
System.out.println("North gate ticket: "+TicketCounter.issue());System.out.println("South gate ticket: "+TicketCounter.issue());
System.out.println("A shared static counter prevents reuse across facility objects.");
Object ticket=new String("Active ticket for TN01AB1111");System.out.println(ticket);ticket=null;
System.out.println("Reference cleared; object may be garbage-collected when unreferenced.");}}