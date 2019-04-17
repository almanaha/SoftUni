package StringProcessingAndRegex;

import java.util.Scanner;

public class RepeatString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] text = sc.nextLine().split(" ");

        StringBuilder builder = new StringBuilder();
        for (String word : text) {
            int count = word.length();
            for (int i = 0; i < count; i++) {
                builder.append(word);
            }
        }
        System.out.println(builder);
    }
}
