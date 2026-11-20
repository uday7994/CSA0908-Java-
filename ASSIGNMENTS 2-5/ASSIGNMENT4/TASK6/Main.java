import java.util.*;
public class Main {
 static class Registration {String student,event;Registration(String s,String e){student=s;event=e;}public String toString(){return student+" -> "+event;}}
 static class Service {Set<String> keys=new HashSet<>();List<Registration> rows=new ArrayList<>();
  void register(String s,String e){if(s.isBlank()||e.isBlank())throw new IllegalArgumentException("Required fields missing");String k=s+"|"+e;if(!keys.add(k))throw new IllegalStateException("Duplicate registration");rows.add(new Registration(s,e));}
  List<Registration> filter(String e){return rows.stream().filter(r->r.event.equals(e)).toList();}
 }
 public static void main(String[] args){Service s=new Service();for(String[] x:new String[][]{{"192411203","TechFest"},{"192411204","MusicFest"},{"192411203","TechFest"}})try{s.register(x[0],x[1]);System.out.println("Registered: "+x[0]);}catch(Exception e){System.out.println("Rejected: "+e.getMessage());}
  System.out.println("TechFest rows: "+s.filter("TechFest").size());}
}
