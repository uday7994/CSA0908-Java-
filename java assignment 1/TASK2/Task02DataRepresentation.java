public class Task02DataRepresentation { public static void main(String[] a) {
int floor=1, slot=2, minutes=61; long entryTimeMillis=1761411600000L; double rate=30.0;
int hours=(minutes+59)/60; double fee=hours*rate; int[] capacities={2,3,1};
String[][] slots=new String[capacities.length][];
for(int f=0;f<capacities.length;f++) slots[f]=new String[capacities[f]];
System.out.println("Floor: "+floor+", Slot: "+slot);
System.out.println("Entry time (epoch ms): "+entryTimeMillis);
System.out.println("Duration: "+minutes+" minutes; billable hours: "+hours);
System.out.println("Fee: Rs "+fee); System.out.println("Jagged array floors: "+slots.length);
}}