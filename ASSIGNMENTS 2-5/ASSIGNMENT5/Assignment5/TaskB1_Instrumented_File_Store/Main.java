import java.nio.file.*;import java.io.*;import java.util.*;
public class Main {
 public static void main(String[] args)throws Exception{Path p=Files.createTempFile("passes",".csv");Files.write(p,List.of("P1001,192311001,Arun,12,4200","P1002,DAMAGED","P1003,192311003,Divya,7,3800"));int valid=0,bad=0;try(BufferedReader r=Files.newBufferedReader(p)){String line;while((line=r.readLine())!=null){String[] f=line.split(",",-1);if(f.length==5){valid++;System.out.println("Valid pass: "+f[0]);}else{bad++;System.out.println("Skipped damaged line: "+line);}}}System.out.println("Valid records: "+valid+", damaged: "+bad);Files.delete(p);}
}
