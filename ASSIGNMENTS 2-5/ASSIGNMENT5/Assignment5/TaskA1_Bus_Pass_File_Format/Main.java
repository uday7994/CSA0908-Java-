import java.io.*;import java.nio.file.*;import java.util.*;
public class Main {
 static class PassStore {
  Path file;PassStore(Path p){file=p;}
  void add(String id,String reg,String name,int route,double amount)throws IOException{try(BufferedWriter w=Files.newBufferedWriter(file,StandardOpenOption.CREATE,StandardOpenOption.APPEND)){w.write(String.join(",",id,reg,name,String.valueOf(route),String.valueOf(amount)));w.newLine();}}
  String[] find(String id)throws IOException{if(!Files.exists(file))return null;try(BufferedReader r=Files.newBufferedReader(file)){String line;while((line=r.readLine())!=null){String[] f=line.split(",",-1);if(f.length==5&&f[0].equals(id))return f;}}return null;}
 }
 public static void main(String[] args)throws Exception{Path p=Files.createTempFile("passes",".csv");PassStore s=new PassStore(p);s.add("P1001","192311001","Arun",12,4200);s.add("P1003","192311003","Divya",7,3800);Files.writeString(p,"P1002,DAMAGED LINE\\n",StandardOpenOption.APPEND);System.out.println(Arrays.toString(s.find("P1003")));System.out.println(Arrays.toString(s.find("P9999")));Files.delete(p);}
}
