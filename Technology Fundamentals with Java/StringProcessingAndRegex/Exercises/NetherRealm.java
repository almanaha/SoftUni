package StringProcessingAndRegex.Exercises;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class NetherRealm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> data = Arrays.stream(sc.nextLine().split(",\\s*"))
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());

        Pattern healthRegex = Pattern.compile("[^\\d+\\-*/.]");
        Pattern digitsRegex = Pattern.compile("[-|+]*[0.0-9]+");

        for (int i = 0; i < data.size(); i++) {
            data.set(i,data.get(i).trim());
            Matcher healthMatcher = healthRegex.matcher(data.get(i));
            Matcher digitMatcher = digitsRegex.matcher(data.get(i));

            double damage = 0;
            while (digitMatcher.find()) {
                damage += Double.parseDouble(digitMatcher.group());
            }
            int health = 0;
            while (healthMatcher.find()) {
                health += healthMatcher.group().charAt(0);
            }

            damage = getFullDamage(data.get(i), damage);

            System.out.printf("%s - %d health, %.2f damage\n", data.get(i), health, damage);
        }
    }

    private static double getFullDamage(String demons, double damage) {
        int multi = 0;
        int divide = 0;
        for (int i = 0; i < demons.length(); i++) {
            if (demons.charAt(i) == '*') {
                multi++;
            } else if (demons.charAt(i) == '/') {
                divide++;
            }
        }
        damage *= (int) Math.pow(2, multi);
        damage /= (int) Math.pow(2, divide);
        return damage;
    }
}
