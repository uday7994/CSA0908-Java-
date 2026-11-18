import java.util.*;import java.util.concurrent.*;
public class Main {
 static class ResultTask implements Callable<String>{
  final int id; ResultTask(int i){id=i;}
  public String call() throws Exception {if(id%7==0)throw new Exception("Corrupt score file "+id);return "Student"+id+" result="+(id%100);}
 }
 public static void main(String[] args)throws Exception{
  ExecutorService pool=Executors.newFixedThreadPool(4);List<Future<String>> fs=new ArrayList<>();int ok=0,fail=0;
  for(int i=1;i<=30;i++)fs.add(pool.submit(new ResultTask(i)));
  for(Future<String> f:fs)try{f.get();ok++;}catch(ExecutionException e){fail++;System.out.println("Handled: "+e.getCause().getMessage());}
  pool.shutdown();System.out.println("Successful files: "+ok);System.out.println("Failed files: "+fail);
 }
}
