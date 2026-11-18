import java.io.*;
import java.nio.file.*;
public class Main {
 public static void main(String[] args) throws Exception {
  Path dir=Files.createTempDirectory("sales"); Path a=dir.resolve("store1.txt"), b=dir.resolve("store2.txt");
  Files.writeString(a,"100\\n200\\n"); Files.writeString(b,"150\\n250\\n");
  int total=0, lines=0;
  for(Path p:new Path[]{a,b}) try(BufferedReader r=Files.newBufferedReader(p)) {
   String line; while((line=r.readLine())!=null){total+=Integer.parseInt(line);lines++;}
   System.out.println("Processed: "+p.getFileName());
  }
  System.out.println("Lines processed: "+lines); System.out.println("Sales total: "+total);
  Files.delete(a); Files.delete(b); Files.delete(dir);
 }
}
