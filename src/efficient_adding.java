import java.util.PriorityQueue;
import java.util.Scanner;

public class efficient_adding {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long cost, output;
        int N = scan.nextInt();
        String line = scan.nextLine();
        line = scan.nextLine();
        String[] lparts = line.split(" ");
        PriorityQueue<Long> heap = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            heap.offer(Long.parseLong(lparts[i]));
        }

        cost = heap.poll() + heap.poll();
        output = cost;
        heap.offer(output);
        while (heap.size() > 1) {
            cost = heap.poll() + heap.poll();
            output += cost;
            heap.offer(cost);
        }

        System.out.println(output);
    }
}
