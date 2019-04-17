package StringProcessingAndRegex.MoreExercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractPersonInfo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = Integer.parseInt(sc.nextLine());
        Pattern pattern = Pattern.compile("@(?<name>[\\\\S\\\\s]*?)\\\\|(.*)#(?<age>[\\\\S\\\\s]*?)\\\\*");
        while (count-- > 0) {
            Matcher matcher = pattern.matcher(sc.nextLine());
            if (matcher.find())
                System.out.printf("%s is %s years old.\n",
                        matcher.group("name"),
                        matcher.group("age"));
        }
    }
}
