public class Main {
 static class Station implements Runnable {
  private final int id; Station(int id){this.id=id;}
  public void run(){try{System.out.println("Station "+id+" scanning");Thread.sleep(80+id*30);System.out.println("Station "+id+" completed 25 scripts");}
   catch(InterruptedException e){Thread.currentThread().interrupt();}}
 }
 public static void main(String[] args)throws Exception{
  Thread[] ts=new Thread[4];
  for(int i=0;i<4;i++){ts[i]=new Thread(new Station(i+1));ts[i].start();}
  for(Thread t:ts)t.join();
  System.out.println("All scanner stations completed.");
 }
}
