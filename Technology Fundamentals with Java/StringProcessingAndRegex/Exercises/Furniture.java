package StringProcessingAndRegex.Exercises;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String regex = "^>+([?<furniture>A-Z{0,}a-z]+)+<<(?<price>\\d+\\.?\\d+)+!([?<quantity>\\d+]+)\\b";
        double totalCost = 0;
        System.out.println("Bought furniture:");

        String input;
        while (!"Purchase".equals(input = sc.nextLine())) {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String furniture = matcher.group(1);
                double price = Double.parseDouble(matcher.group(2));
                double quantity = Double.parseDouble(matcher.group(3));
                System.out.println(furniture);
                totalCost += price * quantity;
            }
        }
        System.out.printf("Total money spend: %.2f", totalCost);
    }
}