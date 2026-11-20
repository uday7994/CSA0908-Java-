import java.io.*;import java.util.*;
public class Main {
 static class Resident implements Serializable{private static final long serialVersionUID=1L;String name,reg;transient String password;transient Object liveConnection;Resident(String n,String r,String p){name=n;reg=r;password=p;}}
 static class Hostel implements Serializable{private static final long serialVersionUID=1L;List<Resident> residents=new ArrayList<>();}
 public static void main(String[] args)throws Exception{Hostel h=new Hostel();h.residents.add(new Resident("Uday","192411203","secret"));ByteArrayOutputStream bytes=new ByteArrayOutputStream();try(ObjectOutputStream out=new ObjectOutputStream(bytes)){out.writeObject(h);}try(ObjectInputStream in=new ObjectInputStream(new ByteArrayInputStream(bytes.toByteArray()))){Hostel copy=(Hostel)in.readObject();Resident r=copy.residents.get(0);System.out.println("Restored: "+r.name+" "+r.reg);System.out.println("Password after deserialize: "+r.password);System.out.println("Serialized bytes: "+bytes.size());}}
}
