import java.util.*;

public class Main {
    static long arrayListQueue(int n) {
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++) list.add(i);
        long start=System.nanoTime();
        while(!list.isEmpty()) list.remove(0);
        return System.nanoTime()-start;
    }
    static long dequeQueue(int n) {
        Deque<Integer> deque=new ArrayDeque<>();
        for(int i=0;i<n;i++) deque.addLast(i);
        long start=System.nanoTime();
        while(!deque.isEmpty()) deque.removeFirst();
        return System.nanoTime()-start;
    }
    public static void main(String[] args) {
        int[] sizes={1000,5000,10000,20000};
        System.out.println("Original: ArrayList remove(0) vs redesigned: ArrayDeque removeFirst()");
        for(int n:sizes) {
            long a=arrayListQueue(n), d=dequeQueue(n);
            System.out.printf("n=%d | ArrayList %.3f ms | ArrayDeque %.3f ms%n",n,a/1e6,d/1e6);
        }
        System.out.println("Redesign: ArrayDeque supports insertion/removal at both ends in amortized O(1).");
        System.out.println("Trade-off: no constant-time indexed access; ArrayList remains useful for random access.");
    }
}
