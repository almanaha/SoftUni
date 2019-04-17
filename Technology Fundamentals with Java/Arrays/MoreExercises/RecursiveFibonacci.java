package Arrays.MoreExercises;

import java.util.*;

public class RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        long sum = getFibonacci(n);
        System.out.println(sum);
    }

    private static long getFibonacci(int n) {
        if (n <= 2) return 1;
        return getFibonacci(n - 1) + getFibonacci(n - 2);
    }
}
