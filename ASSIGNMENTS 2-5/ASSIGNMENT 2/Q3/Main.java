import java.util.*;

public class Main {
    static class FaultyStudent {
        String regNo, name;
        FaultyStudent(String r,String n){regNo=r;name=n;}
        public boolean equals(Object o){return o instanceof FaultyStudent && regNo.equals(((FaultyStudent)o).regNo);}
        // hashCode intentionally missing to demonstrate the contract violation.
    }
    static final class Student {
        private final String regNo, name;
        Student(String r,String n){regNo=r;name=n;}
        public boolean equals(Object o){
            if(this==o)return true;
            if(!(o instanceof Student))return false;
            return regNo.equals(((Student)o).regNo);
        }
        public int hashCode(){return Objects.hash(regNo);}
        public String toString(){return regNo+" "+name;}
    }
    public static void main(String[] args) {
        Set<FaultyStudent> faulty=new HashSet<>();
        faulty.add(new FaultyStudent("192311001","Arun"));
        faulty.add(new FaultyStudent("192311001","Arun"));
        System.out.println("Faulty HashSet size (may show duplicate): "+faulty.size());

        Set<Student> correct=new HashSet<>();
        correct.add(new Student("192311001","Arun"));
        correct.add(new Student("192311002","Divya"));
        correct.add(new Student("192311001","Arun"));
        System.out.println("Correct HashSet size: "+correct.size());
        System.out.println("Unique students: "+correct);

        Set<Student> tree=new TreeSet<>(Comparator.comparing(s -> s.regNo));
        tree.add(new Student("192311001","Arun"));
        tree.add(new Student("192311001","Arun"));
        System.out.println("TreeSet size using regNo comparator: "+tree.size());
    }
}
