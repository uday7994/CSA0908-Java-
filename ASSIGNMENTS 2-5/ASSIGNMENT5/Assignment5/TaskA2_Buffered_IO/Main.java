import java.io.*;import java.nio.file.*;
public class Main {
 static long countBuffered(Path p)throws IOException{long n=0;try(BufferedReader r=Files.newBufferedReader(p)){while(r.readLine()!=null)n++;}return n;}
 static long countByte(Path p)throws IOException{long n=0;try(InputStream in=Files.newInputStream(p)){int b;while((b=in.read())!=-1)if(b=='\\n')n++;}return n;}
 public static void main(String[] args)throws Exception{Path p=Files.createTempFile("attendance",".txt");String data="student1\\nstudent2\\nstudent3\\n";Files.writeString(p,data);long s=System.nanoTime(),a=countByte(p),t1=System.nanoTime()-s;s=System.nanoTime();long b=countBuffered(p),t2=System.nanoTime()-s;System.out.println("Unbuffered lines: "+a+" time(ns): "+t1);System.out.println("Buffered lines: "+b+" time(ns): "+t2);Files.delete(p);}
}
