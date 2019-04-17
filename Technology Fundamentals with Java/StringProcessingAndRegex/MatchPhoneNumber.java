package StringProcessingAndRegex;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchPhoneNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String phoneNum = sc.nextLine();
        Pattern pattern = Pattern.compile("\\+359([- ])2\\1[\\d]{3}\\1[\\d]{4}\\b");
        Matcher matcher = pattern.matcher(phoneNum);
        List<String> phoneBook = new ArrayList<>();
        while (matcher.find()) {
            phoneBook.add(matcher.group());
        }
        System.out.println(String.join(", ",phoneBook));
    }
}
