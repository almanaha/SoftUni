package StacksAndQueues.Exercises;

import java.io.*;
import java.util.*;

public class BasicStackOP2 {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        int[] cmd = Arrays.stream(sc.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Deque<Integer> deque = new ArrayDeque<>();
        Arrays.stream(sc.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .limit(cmd[0])
                .forEach(deque::push);

        while (cmd[1]-- > 0) {
            deque.pop();
        }

        if (deque.contains(cmd[1])) {
            System.out.println("true");
        } else if (deque.size() > 0) {
            deque.stream()
                    .sorted(Comparator.naturalOrder())
                    .limit(1)
                    .forEach(System.out::println);
        } else {
            System.out.println(0);
        }
    }
}
