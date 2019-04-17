package Exams.November2017;

import java.io.*;
import java.util.regex.*;

public class AnonymousVox {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        String text = sc.readLine();
        String holders = sc.readLine();

        Pattern pattern = Pattern.compile("([a-zA-Z]+)(?<placeholder>.*)\\1");
        Pattern value = Pattern.compile("(?<=\\{)(?<text>.*?)(?=\\})");
        Matcher f = pattern.matcher(text);
        Matcher s = value.matcher(holders);

        // use Pattern.quote
        while (f.find() && s.find()) {
            text = text
                    .replaceFirst(
                            Pattern.quote(f.group("placeholder")), s.group("text"));
        }
        System.out.println(text);
    }
}