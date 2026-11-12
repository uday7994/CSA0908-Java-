import java.util.*;

public class Main {
    static volatile int sink;
    static long timeAddEnd(List<Integer> list, int n) {
        long s=System.nanoTime(); for(int i=0;i<n;i++) list.add(i); return System.nanoTime()-s;
    }
    static long timeGet(List<Integer> list, int n) {
        long s=System.nanoTime(); for(int i=0;i<n;i++) sink += list.get(i); return System.nanoTime()-s;
    }
    static long timeIterate(List<Integer> list) {
        long s=System.nanoTime(); for(int x:list) sink += x; return System.nanoTime()-s;
    }
    static long timeFrontRemove(List<Integer> list) {
        long s=System.nanoTime(); while(!list.isEmpty()) sink += list.remove(0); return System.nanoTime()-s;
    }
    public static void main(String[] args) {
        int[] sizes={1000,5000,10000};
        for(int n:sizes) {
            System.out.println("\\nPlaylist size: "+n);
            for(String type:new String[]{"ArrayList","LinkedList"}) {
                List<Integer> list=type.equals("ArrayList")?new ArrayList<>():new LinkedList<>();
                long add=timeAddEnd(list,n);
                long get=timeGet(list,n);
                long iterate=timeIterate(list);
                System.out.printf("%-10s addEnd %.3f ms | indexedGet %.3f ms | iterate %.3f ms%n",
                    type,add/1e6,get/1e6,iterate/1e6);
            }
            ArrayDeque<Integer> deque=new ArrayDeque<>();
            long s=System.nanoTime(); for(int i=0;i<n;i++) deque.addLast(i);
            while(!deque.isEmpty()) sink += deque.removeFirst();
            System.out.printf("ArrayDeque addLast+removeFirst %.3f ms%n",(System.nanoTime()-s)/1e6);
        }
        System.out.println("\\nNote: timing depends on JVM, machine load and warm-up.");
    }
}
