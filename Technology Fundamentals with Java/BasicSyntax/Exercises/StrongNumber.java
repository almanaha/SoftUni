package BasicSyntax.Exercises;

import java.util.Scanner;

public class StrongNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int number = n;
        int total = 0;

        while (number != 0){
            int lastDigit = number % 10;
            number /= 10;
            int factorial = 1;

            for (int i = 1; i<= lastDigit; i++){
                factorial *= i;
            }
            total += factorial;
        }
        if (total == n) System.out.println("yes");
        else System.out.println("no");

    }
}
