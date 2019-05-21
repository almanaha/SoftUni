package StacksAndQueues.Exercises;

import java.util.*;

public class BasicStackOP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] commands = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        Deque<Integer> stack = new ArrayDeque<>();

        int n = commands[0];
        int s = commands[1];
        int x = commands[2];


        Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .limit(n)
                .forEach(stack::push);

        for (int i = 0; i < s; i++) {
            stack.poll();
        }

        if (stack.contains(x)) {
            System.out.println(true);
        } else if (stack.isEmpty()) {
            System.out.println(0);
        } else {
            Collections.min(stack);
        }
    }
}
