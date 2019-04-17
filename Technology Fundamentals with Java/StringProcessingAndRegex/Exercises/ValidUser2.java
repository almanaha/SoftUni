package StringProcessingAndRegex.Exercises;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidUser2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String usernames = sc.nextLine();
        Pattern p = Pattern.compile("[A-Za-z]+[\\d]\\w{3,16}");
        Matcher matcher = p.matcher(usernames);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
