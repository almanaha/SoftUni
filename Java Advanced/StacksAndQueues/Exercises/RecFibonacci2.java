package StacksAndQueues.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class RecFibonacci2 {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(sc.readLine());

        Deque<Long> stack = new ArrayDeque<>();
        stack.push(1L);
        stack.push(1L);

        for (int i = 2; i <= n; i++)
        {
            long minusOne = stack.pop();
            long minusTwo = stack.peek();
            stack.push(minusOne);

            stack.push(minusOne + minusTwo);
        }

        System.out.println(stack.peek());
    }
}