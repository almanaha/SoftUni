package Methods;

import java.util.Scanner;

public class SignOfInt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        PositiveOrNegative(n);
    }

    public static void PositiveOrNegative(int n) {
        if (n < 0) System.out.printf("The number %d is negative.",n);
        else if (n > 0) System.out.printf("The number %d is positive.",n);
        else System.out.printf("The number %d is zero.",n);
    }
}
