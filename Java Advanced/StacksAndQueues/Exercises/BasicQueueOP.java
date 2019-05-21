package StacksAndQueues.Exercises;

import java.io.*;
import java.util.*;

public class BasicQueueOP {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        Deque<Integer> que = new ArrayDeque<>();

        int[] data = Arrays.stream(sc.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Arrays.stream(sc.readLine().split(" "))
                .limit(data[0])
                .mapToInt(Integer::parseInt)
                .forEach(que::offer);

        for (int i = 0; i < data[1]; i++) {
            que.poll();
        }

        if (que.isEmpty()) {
            System.out.println(0);
        } else if (que.contains(data[2])) {
            System.out.println(true);
        } else {
            System.out.println(que.stream().sorted(Integer::compareTo)
                    .mapToInt(Integer::valueOf)
                    .min()
                    .getAsInt());
        }
    }
}
