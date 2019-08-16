package EXAMS.August2016;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class SecondNature2 {

    public static void main(String[] args) throws IOException {

        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));


        Deque<Integer> flowers = new ArrayDeque<>();
        Deque<Integer> buckets = new ArrayDeque<>();
        Arrays.stream(sc.readLine().split("\\s+"))
                .map(Integer::valueOf)
                .forEach(flowers::offer);
        Arrays.stream(sc.readLine().split("\\s+"))
                .map(Integer::valueOf)
                .forEach(buckets::push);

        LinkedList<Integer> nature = new LinkedList<>();

        while (!flowers.isEmpty() && !buckets.isEmpty()) {
            int currentFlower = flowers.peek();
            int currentBucket = buckets.peek();

            int restOfBucket = currentBucket - currentFlower;

            if (restOfBucket == 0) {
                nature.add(currentFlower);
                buckets.pop();
            }
            if (restOfBucket > 0 && buckets.size() > 1) {
                buckets.pop();
                int nextBucket = buckets.pop() + restOfBucket;
                buckets.push(nextBucket);
            } else if (restOfBucket > 0 && buckets.size() == 1 && !flowers.isEmpty()) {
                buckets.pop();
                buckets.push(restOfBucket);
            }
            flowers.poll();
            if (restOfBucket < 0) {
                currentFlower -= currentBucket;
                buckets.pop();
                flowers.addFirst(currentFlower);
            }

        }

        if (flowers.size() == 0) {
            while (!buckets.isEmpty()) {
                System.out.print(buckets.pop() + " ");
            }
        } else {
            for (Integer flower : flowers) {
                System.out.printf("%d ", flower);
            }
        }
        System.out.println();
        System.out.println(nature.size() > 0
                ? nature.stream().map(String::valueOf).collect(Collectors.joining(" "))
                : "None");
    }
}
