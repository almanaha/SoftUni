package StringProcessingAndRegex.Exercises;

import java.util.Scanner;

public class CharacterMultiplier {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split(" ");
        multiplyChars(input[0], input[1]);
    }

    private static void multiplyChars(String first, String second) {
        int result = 0;
        int length = Math.min(first.length(), second.length());
        for (int i = 0; i < length; i++) {
            result += first.charAt(i) * second.charAt(i);
        }

        if (first.length() > second.length()) {
            for (int j = length; j < first.length(); j++) {
                result += first.charAt(j);
            }
        } else if (second.length() > first.length()) {
            for (int j = length; j < second.length(); j++) {
                result += second.charAt(j);
            }
        }

        System.out.println(result);
    }
}
