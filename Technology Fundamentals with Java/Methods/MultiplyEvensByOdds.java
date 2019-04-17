package Methods;

import java.util.Scanner;

public class MultiplyEvensByOdds {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Math.abs(Integer.parseInt(sc.nextLine()));
        int sum = getMultipleOfEvensAndOdds(n);
        System.out.println(sum);
    }

    public static int getMultipleOfEvensAndOdds(int n) {
        int oddSum = getOddSum(n);
        int evenSum = getEvenSum(n);
        return oddSum * evenSum;
    }

    public static int getOddSum(int n) {
        int sum = 0;
        while (n > 0){
            int lastDigit = n % 10;
            n /= 10;

            if (lastDigit % 2 != 0) {
                sum += lastDigit;
            }
        }
        return sum;
    }
    public static int getEvenSum(int n) {
        int sum = 0;
        while (n > 0){
            int lastDigit = n % 10;
            n /= 10;

            if (lastDigit % 2 == 0) {
                sum += lastDigit;
            }
        }
        return sum;
    }
}
