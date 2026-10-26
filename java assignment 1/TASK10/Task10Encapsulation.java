class EncapsulatedSlot {private int number;EncapsulatedSlot(int n){setNumber(n);}public int getNumber(){return number;}
public void setNumber(int n){if(n<0)throw new IllegalArgumentException("Slot number cannot be negative");number=n;}}
public class Task10Encapsulation {public static void main(String[] a){EncapsulatedSlot s=new EncapsulatedSlot(4);
System.out.println("Validated slot number: "+s.getNumber());try{s.setNumber(-1);}catch(IllegalArgumentException e){System.out.println("Rejected invalid update: "+e.getMessage());}}}