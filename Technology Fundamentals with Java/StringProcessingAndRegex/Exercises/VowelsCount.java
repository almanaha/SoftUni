package StringProcessingAndRegex.Exercises;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VowelsCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine();
        Pattern p = Pattern.compile("[AEIOUYaeiouy]");
        Matcher m = p.matcher(text);

        int count = 0;
        while (m.find()) {
            count++;
        }
        System.out.println("Vowels: " + count);
    }
}
