package Exams.July2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SUBarIncome {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        Pattern pattern = Pattern.compile("\\%([A-Z][a-z]+)\\%[^|$%.]*\\<(\\w+)\\>[^|$%.]*\\|(\\d+)\\|[^|$%.]*?(\\d+([.]\\d+)?)\\$");

        double total = 0d;
        String input;
        while (!"end of shift".equals(input = sc.readLine())){
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()){
                String name = matcher.group(1);
                String product = matcher.group(2);
                int count = Integer.parseInt(matcher.group(3));
                double price = Double.parseDouble(matcher.group(4));
                double sum = count * price;
                total += sum;
                System.out.printf("%s: %s - %.2f\n",name,product,sum);
            }
        }
        System.out.printf("Total income: %.2f",total);
    }
}
