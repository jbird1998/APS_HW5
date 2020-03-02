import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static int[] rank;
    static int[] sets;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        String[] lparts = line.split(" ");
        ArrayList<String> output = new ArrayList<>();
        int N = Integer.parseInt(lparts[0]);
        int Q = Integer.parseInt(lparts[1]);

        sets = new int[N];
        rank = new int[N];
        for (int i = 0; i < N; i++) {
            sets[i] = i;
        }

        for (int i = 0; i < Q; i++) {
            line = scan.nextLine();
            lparts = line.split(" ");
            char op = lparts[0].charAt(0);
            int a = Integer.parseInt(lparts[1]);
            int b = Integer.parseInt(lparts[2]);
            if (op == '?') {
                if (find(a) == find(b)) {
                    output.add("yes");
                } else {
                    output.add("no");
                }
            } else {
                union(a, b);
            }
        }

        for (String o: output) {
            System.out.println(o);
        }
    }

    public static int find(int i) {
        // Returns the index
        if (sets[i] == i) {
            return i;
        }
        sets[i] = find(sets[i]);
        return sets[i];
    }

    public static void union(int a, int b) {
        int aP = find(a);
        int bP = find(b);
        if (aP == bP) {
            return;
        }
        if (rank[aP] < rank[bP]) {
            sets[aP] = bP;
        } else if (rank[bP] < rank[aP]) {
            sets[bP] = aP;
        } else {
            sets[bP] = aP;
            rank[aP] += 1;
        }
    }
}
