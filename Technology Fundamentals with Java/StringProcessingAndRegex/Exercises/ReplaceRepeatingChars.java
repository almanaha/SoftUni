package StringProcessingAndRegex.Exercises;

import java.util.*;

public class ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder letters = new StringBuilder();
        String data = sc.nextLine();
        for (int i = 0; i < data.length() - 1; i++) {
            if (data.charAt(i) != data.charAt(i + 1)) {
                letters.append(data.charAt(i));
            }
            if (i == data.length() - 2) {
                letters.append(data.charAt(data.length() - 1));
            }
        }
        System.out.println(letters);
    }
}
