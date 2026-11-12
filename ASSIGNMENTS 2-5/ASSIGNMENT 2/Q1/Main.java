import java.util.*;

public class Main {
    static String buildWithString(int tickets, int fields) {
        String result = "";
        for (int t = 0; t < tickets; t++) {
            String ticket = "";
            for (int f = 1; f <= fields; f++) ticket = ticket + "FIELD" + f + "=" + f + ";";
            result = result + ticket;
        }
        return result;
    }
    static String buildWithBuilder(int tickets, int fields) {
        StringBuilder all = new StringBuilder();
        for (int t = 0; t < tickets; t++) {
            StringBuilder ticket = new StringBuilder();
            for (int f = 1; f <= fields; f++) ticket.append("FIELD").append(f).append("=").append(f).append(";");
            all.append(ticket);
        }
        return all.toString();
    }
    static String buildWithBuffer(int tickets, int fields) {
        StringBuffer all = new StringBuffer();
        for (int t = 0; t < tickets; t++) {
            StringBuffer ticket = new StringBuffer();
            for (int f = 1; f <= fields; f++) ticket.append("FIELD").append(f).append("=").append(f).append(";");
            all.append(ticket);
        }
        return all.toString();
    }
    static long measure(int mode, int tickets, int fields) {
        long start = System.nanoTime();
        String result = mode == 0 ? buildWithString(tickets, fields)
                : mode == 1 ? buildWithBuilder(tickets, fields) : buildWithBuffer(tickets, fields);
        if (result.isEmpty()) throw new AssertionError();
        return System.nanoTime() - start;
    }
    public static void main(String[] args) {
        int[][] workloads = {{1, 5}, {1000, 20}, {3000, 50}};
        String[] names = {"String +", "StringBuilder", "StringBuffer"};
        for (int[] w : workloads) {
            System.out.println("\\nWorkload: " + w[0] + " tickets x " + w[1] + " fields");
            for (int mode = 0; mode < 3; mode++) {
                long total = 0;
                for (int r = 0; r < 3; r++) total += measure(mode, w[0], w[1]);
                System.out.printf("%-14s average: %.3f ms%n", names[mode], total / 3.0 / 1_000_000);
            }
        }
        System.out.println("\\nRecommendation: StringBuilder for local ticket creation; StringBuffer for shared synchronized appends.");
    }
}
