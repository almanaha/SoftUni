package StringProcessingAndRegex.Exercises;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftUniBarIncome2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Pattern pattern = Pattern
                .compile("\\%(?<customer>[A-Z][a-z]+)" +
                        "\\%[^|$%.]*\\<(?<product>\\w+)\\>" +
                        "[^|$%.]*\\|(?<count>\\d+)\\|" +
                        "[^|$%.]*?(?<price>\\d+([.]\\d+)?)\\$");
        double totalIncome = 0;
        String input;
        while (!"end of shift".equals(input = sc.nextLine())) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.matches()) {
                String name = matcher.group("customer");
                String product = matcher.group("product");
                int quantity = Integer.parseInt(matcher.group("count"));
                double price = Double.parseDouble(matcher.group("price"));

                totalIncome += quantity * price;
                System.out.println(String.format("%s: %s - %.2f",
                        name, product, quantity * price));
            }
        }
        System.out.printf("Total income: %.2f\n", totalIncome);
    }
}
