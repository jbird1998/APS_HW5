import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class running_median {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line;
        int numLines = 0;
        long first = 0, second, median = -1L;
        long num;
        PriorityQueue<Long> min = new PriorityQueue<>(50000);
        PriorityQueue<Long> max = new PriorityQueue<>(50000, new maximum());
        StringBuilder builder = new StringBuilder(1000000);
        while (scan.hasNextLine()) {
            line = scan.nextLine();
            line = line.trim();
            if (line.length() == 0) {
                continue;
            }
            num = Long.parseLong(line);
            numLines++; // the current number of numbers scanned in
            if (numLines == 1) {
                first = num;
                median = num;
            } else if (numLines == 2) {
                second = num;
                median = (first + second) / 2L;
                if (first < second) {
                    max.offer(first);
                    min.offer(second);
                } else {
                    min.offer(first);
                    max.offer(second);
                }
            } else {
                first = min.peek();
                second = max.peek();
                if (min.size() == max.size()) {
                    if (num <= first && num >= second) {
                        median = num;
                        max.offer(num);
                    } else if (num > first) {
                        median = first;
                        min.offer(num);
                    } else {
                        median = second;
                        max.offer(num);
                    }
                } else if (min.size() > max.size()) {
                    if (num <= first && num >= second) {
                        median = (num + first) / 2L;
                        max.offer(num);
                    } else if (num > first) {
                        min.offer(num);
                        max.offer(min.poll());
                        median = (max.peek() + min.peek()) / 2L;
                    } else {
                        median = (first + second) / 2L;
                        max.offer(num);
                    }
                } else {
                    if (num <= first && num >= second) {
                        median = (num + second) / 2L;
                        min.offer(num);
                    } else if (num > first) {
                        median = (first + second) / 2L;
                        min.offer(num);
                    } else {
                        max.offer(num);
                        min.offer(max.poll());
                        median = (max.peek() + min.peek()) / 2L;
                    }
                }
            }
            if (numLines == 1) {
                builder.append(median);
            } else {
                builder.append("\n");
                builder.append(median);
            }
        }
        System.out.println(builder.toString());
    }

    public static class maximum implements Comparator<Long> {

        @Override
        public int compare(Long l1, Long l2) {
            if (l1 < l2) {
                return 1;
            } else if (l1 > l2) {
                return -1;
            }
            return 0;
        }
    }
}
