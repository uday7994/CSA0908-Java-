public class Main {
 static class Wallet {int balance; Wallet(int b){balance=b;}}
 static void transfer(Wallet a,Wallet b,int amount){
  Wallet first=System.identityHashCode(a)<System.identityHashCode(b)?a:b;
  Wallet second=first==a?b:a;
  synchronized(first){synchronized(second){a.balance-=amount;b.balance+=amount;}}
 }
 static class TokenCounter {
  int[] buffer=new int[5]; int count,in,out;
  synchronized void put(int v)throws InterruptedException{while(count==5)wait();buffer[in]=v;in=(in+1)%5;count++;notifyAll();}
  synchronized int take()throws InterruptedException{while(count==0)wait();int v=buffer[out];out=(out+1)%5;count--;notifyAll();return v;}
 }
 public static void main(String[] args)throws Exception{
  TokenCounter c=new TokenCounter();
  Thread producer=new Thread(()->{try{for(int i=1;i<=8;i++)c.put(i);}catch(InterruptedException e){Thread.currentThread().interrupt();}});
  Thread consumer=new Thread(()->{try{for(int i=1;i<=8;i++)System.out.println("Consumed token: "+c.take());}catch(InterruptedException e){Thread.currentThread().interrupt();}});
  producer.start();consumer.start();producer.join();consumer.join();System.out.println("Counter remaining: "+c.count);
 }
}
