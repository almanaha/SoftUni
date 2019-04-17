package StringProcessingAndRegex.MoreExercises;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RageQuit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String symbols = sc.nextLine();
        Pattern pattern = Pattern.compile("(([^\\d]+)(\\d+))");
        Matcher matcher = pattern.matcher(symbols);

        StringBuilder result = new StringBuilder();
        while (matcher.find()){
            String message = matcher.group(2);
            int repeat = Integer.parseInt(matcher.group(3));
            for (int i = 0; i < repeat; i++) {
                result.append(message.toUpperCase());
            }
        }
        long count = result.chars().distinct().count();
        System.out.println("Unique symbols used: " + count);
        System.out.println(result);
    }
}
