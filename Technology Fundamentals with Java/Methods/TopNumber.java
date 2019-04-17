package Methods;

import java.util.Scanner;

public class TopNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = Integer.parseInt(sc.nextLine());

        for (int i = 17; i <= number; i++) {
            boolean isDiv = isDivisible(i);
            boolean containsOdd = Odd(i);
            if (isDiv && containsOdd) {
                System.out.println(i);
            }
        }
    }

    private static boolean isDivisible(int i) {
        int sum = 0;
        while (i != 0) {
            int lastDigit = i % 10;
            i /= 10;
            sum += lastDigit;
        }
        if (sum % 8 == 0) {
            return true;
        }
        return false;
    }

    private static boolean Odd(int y) {
        while (y != 0) {
            int digit = y % 10;
            y /= 10;
            if (digit % 2 == 1) {
                return true;
            }
        }
        return false;
    }
}




