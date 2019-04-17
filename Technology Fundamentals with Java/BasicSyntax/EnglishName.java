package BasicSyntax;

import java.util.Scanner;

public class EnglishName {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = Integer.parseInt(sc.nextLine());
        int lastDigit = x % 10;
        if (lastDigit == 1) System.out.println("SpringVacationTrip");
        else if (lastDigit == 2) System.out.println("HelloFrance");
        else if (lastDigit == 3) System.out.println("LastStop");
        else if (lastDigit == 4) System.out.println("four");
        else if (lastDigit == 5) System.out.println("five");
        else if (lastDigit == 6) System.out.println("six");
        else if (lastDigit == 7) System.out.println("seven");
        else if (lastDigit == 8) System.out.println("eight");
        else if (lastDigit == 9)System.out.println("nine");
        else System.out.println("zero");
    }
}
