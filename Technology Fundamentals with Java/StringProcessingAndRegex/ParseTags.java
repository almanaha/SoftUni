package StringProcessingAndRegex;

import java.util.*;

public class ParseTags {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine();
        int startIndex = text.indexOf("<upcase>");

        while (startIndex != -1) {
            int endIndex = text.indexOf("</upcase>");
            //startIndex + 8 ---> sp we can skip "</upcase>"
            String value = text.substring(startIndex + 8, endIndex);

            text = text.replaceFirst(value, value.toUpperCase());
            text = text.replaceFirst("<upcase>", "");
            text = text.replaceFirst("</upcase>", "");

            startIndex = text.indexOf("<upcase>");
        }
        System.out.println(text);
    }
}
