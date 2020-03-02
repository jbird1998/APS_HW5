import java.util.Scanner;

public class bitwise_or {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        String[] lparts = line.split(" ");
        long N = Long.parseLong(lparts[0]);
        long L = Long.parseLong(lparts[1]);
        long R = Long.parseLong(lparts[2]);
        long x = 0;

        int sigbit = 0;
        long copy = R;
        while (copy > 1L) {
            copy = copy >> 1;
            sigbit++;
        }

        long orPart;
        while (sigbit >= 0) {
            orPart = 1L << sigbit;
            if (((N & orPart) == 0L && (x | orPart) <= R) || (x + orPart - 1) < L) {
                x = x | orPart;
            }
            sigbit--;
        }
        System.out.println(x);
    }
}
