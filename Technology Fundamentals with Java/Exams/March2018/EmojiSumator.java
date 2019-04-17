package Exams.March2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiSumator {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String text = sc.readLine();
        List<String> emojis = new ArrayList<>();

        Pattern pattern = Pattern.compile("(?<=[,.!? ]):([a-z]{4,}):(?=[,.!? ])");
        Matcher matcher = pattern.matcher(text);

        int sum = Arrays.stream(sc.readLine().split(":"))
                .mapToInt(Integer::parseInt)
                .sum();

        int multiplier = 0;
        int total = 0;

        while (matcher.find()) {
            int currentSum = 0;
            emojis.add(matcher.group());
            StringBuilder sb = new StringBuilder(matcher.group().replaceAll(":", ""));
            for (int i = 0; i < sb.length(); i++) {
                currentSum += sb.charAt(i);
            }
            if (currentSum == sum) {
                multiplier += 2;
            }
            total += currentSum;
        }
        if (!emojis.isEmpty()) {
            System.out.println("Emojis found: " + String.join(", ", emojis));
        }
        if (multiplier > 0) {
            total *= multiplier;
        }
        System.out.println("Total Emoji Power: " + total);


    }
}
