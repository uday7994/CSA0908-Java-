import java.util.*;

public class Main {
    static final class Medicine {
        String code,name; int stock;
        Medicine(String c,String n,int s){code=c;name=n;stock=s;}
        public String toString(){return code+" "+name+" stock="+stock;}
    }
    public static void main(String[] args) {
        Map<String,Medicine> hash=new HashMap<>();
        Map<String,Medicine> tree=new TreeMap<>();
        Map<String,Medicine> linked=new LinkedHashMap<>();
        String[][] rows={{"M103","Paracetamol","120"},{"M101","Amoxicillin","80"},
                         {"M105","Cetirizine","60"},{"M102","VitaminC","200"},{"M104","Ibuprofen","90"}};
        for(String[] r:rows){
            Medicine m=new Medicine(r[0],r[1],Integer.parseInt(r[2]));
            hash.put(m.code,m); tree.put(m.code,m); linked.put(m.code,m);
        }
        System.out.println("HashMap lookup M102: "+hash.get("M102"));
        System.out.println("\\nTreeMap report (code order):");
        tree.forEach((k,v)->System.out.println(v));
        System.out.println("\\nLinkedHashMap report (insertion order):");
        linked.forEach((k,v)->System.out.println(v));
        long start=System.nanoTime();
        for(int i=0;i<100000;i++) hash.get("M102");
        System.out.printf("\\n100000 HashMap lookups: %.3f ms%n",(System.nanoTime()-start)/1e6);
        System.out.println("HashMap: average O(1) lookup; TreeMap: O(log n); LinkedHashMap: average O(1).");
    }
}
