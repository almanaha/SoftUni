package StringProcessingAndRegex.MoreExercises;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TreasureFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pattern regex = Pattern
                .compile("((?<=&)(?<type>[\\w\\s]+)(?=&)).*" +
                        "(?<=<)(?<coordinates>[\\w]+)(?=>)");

        int[] key = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        String line;
        while (!"find".equals(line = scanner.nextLine())) {
            StringBuilder sb = new StringBuilder();
            if (key.length < line.length()) {
                for (int i = 0, j = 0; i < line.length(); i++, j++) {
                    char curr = (char) ((int) line.charAt(i) - key[j]);
                    sb.append(curr);
                    if (j == key.length - 1) {
                        j = -1;
                    }
                }
            } else {
                for (int i = 0, j = 0; i < line.length(); i++, j++) {
                    char curr = (char) ((int) line.charAt(i) - key[j]);
                    sb.append(curr);
                }
            }
            //print
            Matcher gold = regex.matcher(sb);
            if (gold.find()) {
                System.out.printf("Found %s at %s%n",
                        gold.group("type"),
                        gold.group("coordinates"));
            }
        }
    }
}
