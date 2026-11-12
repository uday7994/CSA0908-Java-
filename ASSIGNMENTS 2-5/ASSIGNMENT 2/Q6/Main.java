import java.util.*;

public class Main {
    static class Patient {
        final String name; final int severity; final long arrival;
        Patient(String n,int s,long a){name=n;severity=s;arrival=a;}
        public String toString(){return name+"(S"+severity+")";}
    }
    private long counter=0;
    private final PriorityQueue<Patient> queue=new PriorityQueue<>(
        Comparator.comparingInt((Patient p)->p.severity)
                  .thenComparingLong(p->p.arrival));
    void admit(String name,int severity){queue.add(new Patient(name,severity,counter++));}
    Patient next(){return queue.poll();}
    public static void main(String[] args) {
        Main er=new Main();
        er.admit("Ravi",3); er.admit("Meena",1); er.admit("John",3);
        er.admit("Asha",5); er.admit("Kumar",1); er.admit("Lata",2);
        StringBuilder order=new StringBuilder(); Patient p;
        while((p=er.next())!=null) order.append(p).append(' ');
        System.out.println("Treatment order: "+order.toString().trim());
        System.out.println("Add patient: O(log n); remove next: O(log n).");
    }
}
