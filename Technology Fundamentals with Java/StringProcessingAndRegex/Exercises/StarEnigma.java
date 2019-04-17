package StringProcessingAndRegex.Exercises;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Set<String> attacked = new TreeSet<>();
        Set<String> destroyed = new TreeSet<>();

        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String data = sc.nextLine();
            int minus = 0;
            for (int j = 0; j < data.length(); j++) {
                if (data.charAt(j) == 's' ||
                        data.charAt(j) == 'S' || data.charAt(j) == 't' ||
                        data.charAt(j) == 'A' || data.charAt(j) == 'r' ||
                        data.charAt(j) == 'a' || data.charAt(j) == 'R' ||
                        data.charAt(j) == 'T') {
                    minus++;
                }
            }
            String text = "";
            for (int j = 0; j < data.length(); j++) {
                char c = (char) (data.charAt(j) - minus);
                text += c;
            }
            Pattern pattern = Pattern
                    .compile(".*?@([a-zA-Z]+)[^@\\-!>]*:(\\d+)[^@\\-!>]*!([AD])![^@\\-!>]*->(\\d+)");
            Matcher matcher = pattern.matcher(text);
            if (matcher.find()) {
                String planet = matcher.group(1);
                String type = matcher.group(3);

                if (type.equals("A")) {
                    attacked.add(planet);
                } else {
                    destroyed.add(planet);
                }
            }
        }
        System.out.println("Attacked planets: " + attacked.size());
        if (!attacked.isEmpty()) {
            attacked.stream().forEach(e -> System.out.println("-> " + e));
        }
        System.out.println("Destroyed planets: " + destroyed.size());
        destroyed.stream().forEach(e -> System.out.println("-> " + e));
    }
}
