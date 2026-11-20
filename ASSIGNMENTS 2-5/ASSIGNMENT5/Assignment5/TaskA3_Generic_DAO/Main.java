import java.util.*;
interface Dao<T,K>{void insert(T x);Optional<T> findById(K id);List<T> findAll();boolean delete(K id);}
public class Main {
 static class Student{String reg,name;Student(String r,String n){reg=r;name=n;}public String toString(){return reg+" "+name;}}
 static class StudentDao implements Dao<Student,String>{Map<String,Student> data=new LinkedHashMap<>();public void insert(Student s){data.put(s.reg,s);}public Optional<Student> findById(String id){return Optional.ofNullable(data.get(id));}public List<Student> findAll(){return new ArrayList<>(data.values());}public boolean delete(String id){return data.remove(id)!=null;}}
 public static void main(String[] args){StudentDao dao=new StudentDao();dao.insert(new Student("192411203","Uday"));dao.insert(new Student("192411204","Ravi"));System.out.println("Find: "+dao.findById("192411203"));System.out.println("All: "+dao.findAll());}
}
