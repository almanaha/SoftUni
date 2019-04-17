package Methods;

import java.util.Scanner;

public class FactorialDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int first = Integer.parseInt(scanner.nextLine());
        int second = Integer.parseInt(scanner.nextLine());

        System.out.printf("%.2f",factorial(first) / factorial(second));
    }

    private static double factorial(double n) {
        if (n < 1) {
            return 1;
        }
        return (n * factorial(n - 1));
    }
}
