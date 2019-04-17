package StringProcessingAndRegex.Exercises;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String numbers = sc.nextLine();
        Pattern pattern = Pattern.compile("(^|(?<=\\s))-?\\d+(\\.\\d+)?($|(?=\\s))");
        Matcher matcher = pattern.matcher(numbers);
        while (matcher.find()) {
            System.out.print(matcher.group() + " ");
        }
    }
}
