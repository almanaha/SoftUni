package StringProcessingAndRegex.Exercises;

import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine();

        for (int i = 0; i < text.length(); i++) {
            char symbol = (char)(text.charAt(i) + 3);
            System.out.print(symbol);
        }
    }
}
