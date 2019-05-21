package StacksAndQueues.Exercises;

import java.util.Scanner;

public class RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = Integer.parseInt(sc.nextLine());
        memory = new long[x + 1];

        System.out.println(Fibonacci(x));
    }

    static long[] memory;

    private static long Fibonacci(int x) {
        if (x <= 2){
            return 1;
        }
        if (memory[x] != 0){
            return memory[x];
        }
        return memory[x] = Fibonacci(x - 1) + Fibonacci(x - 2);
    }
}