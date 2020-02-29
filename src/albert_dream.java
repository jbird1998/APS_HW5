import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class albert_dream {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        HashMap<String, Integer> dictionary = new HashMap<>();
        ArrayList<String> output = new ArrayList<>();
        StringBuilder builder = new StringBuilder(200);
        String line;
        String result;
        int n;
        while (scan.hasNextLine()) {
            line = scan.nextLine().toLowerCase();
            n = line.length();
            for (int i = 0; i < n; i++) {
                char c = line.charAt(i);
                if (c >= 97 && c <= 122) {
                    builder.append(c);
                } else {
                    if (builder.length() > 0) {
                        result = builder.toString();
                        if (dictionary.get(result) == null) {
                            dictionary.put(result, 1);
                            output.add(result);
                        }
                        builder = new StringBuilder(200);
                    }
                }
            }
            if (builder.length() > 0) {
                result = builder.toString();
                if (dictionary.get(result) == null) {
                    dictionary.put(result, 1);
                    output.add(result);
                }
                builder = new StringBuilder(200);
            }
        }
        Collections.sort(output);
        for (String o: output) {
            System.out.println(o);
        }
    }
}
