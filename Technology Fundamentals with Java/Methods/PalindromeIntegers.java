package Methods;

import java.util.Scanner;

public class PalindromeIntegers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String number = sc.nextLine();

        while (!number.equals("END")) {
            String copy = Polindrome(number);
            if (copy.equals(number)) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
            number = sc.nextLine();
        }
    }

    private static String Polindrome(String s) {
        int num = Integer.parseInt(s);
        String copy = "";
        while (num >= 1) {
            int last = num % 10;
            num /= 10;
            copy += last;
        }
        return copy;
    }
}
