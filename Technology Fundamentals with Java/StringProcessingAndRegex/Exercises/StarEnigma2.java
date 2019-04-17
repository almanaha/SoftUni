package StringProcessingAndRegex.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma2 {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        //Pattern.CASE_INSENSITIVE also match capital letters
        Pattern star = Pattern.compile("[star]", Pattern.CASE_INSENSITIVE);
        Pattern planets = Pattern
                .compile(".*?@([a-zA-Z]+)[^@\\-!>]*:(\\d+)[^@\\-!>]*!([AD])![^@\\-!>]*->(\\d+)");

        List<String> attacked = new ArrayList<>();
        List<String> destroyed = new ArrayList<>();

        int n = Integer.parseInt(sc.readLine());
        while (n-- > 0) {
            String encrypted = sc.readLine();
            Matcher matcher = star.matcher(encrypted);
            int count = 0;
            while (matcher.find()) {
                count++;
            }

            StringBuilder message = new StringBuilder();
            for (int i = 0; i < encrypted.length(); i++) {
                message.append(
                        String.valueOf(Character.toChars(encrypted.charAt(i) - count)));
            }
            Matcher pat = planets.matcher(message);
            if (pat.matches()) {
                String planet = pat.group(1);
                String type = pat.group(3);
                if (type.equals("A")) {
                    attacked.add(planet);
                } else {
                    destroyed.add(planet);
                }
            }
        }

        System.out.println("Attacked planets: " + attacked.size());
        if (!attacked.isEmpty()) {
            attacked.stream()
                    .sorted(String::compareTo)
                    .forEach(e -> System.out.println("-> " + e));
        }
        System.out.println("Destroyed planets: " + destroyed.size());
        destroyed.stream()
                .sorted(String::compareTo)
                .forEach(e -> System.out.println("-> " + e));

    }
}
