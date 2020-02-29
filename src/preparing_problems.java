import java.util.Scanner;

public class preparing_problems {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int S = scan.nextInt();
        String line = scan.nextLine();
        line = scan.nextLine();
        String[] lparts1 = line.split(" ");
        line = scan.nextLine();
        String[] lparts2 = line.split(" ");

        for (int i = 0; i < 12; i++) {
            int num = Integer.parseInt(lparts2[i]);
            if (S >= num) {
                System.out.println("A lot of grading.");
                S -= num;
            } else {
                System.out.println("No homework.");
            }
            S += Integer.parseInt(lparts1[i]);
        }
    }
}
