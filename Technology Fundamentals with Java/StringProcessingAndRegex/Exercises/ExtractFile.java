package StringProcessingAndRegex.Exercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractFile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine();
        String file = text.substring(text.lastIndexOf("\\") + 1);

        Pattern pattern = Pattern.compile("(.*)\\.(.*)");
        Matcher matcher = pattern.matcher(file);

        if (matcher.find()) {
            System.out.printf("File name: %s%n", matcher.group(1));
            System.out.printf("File extension: %s%n", matcher.group(2));
        }
    }
}
