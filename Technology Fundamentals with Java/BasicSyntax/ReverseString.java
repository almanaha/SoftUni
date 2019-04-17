package BasicSyntax;

import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        StringBuilder reversedString = new StringBuilder(text);
        reversedString.reverse();

        System.out.println(reversedString);
    }
}
