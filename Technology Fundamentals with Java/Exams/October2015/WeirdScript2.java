package Exams.October2015;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WeirdScript2 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int keyNumber = Integer.parseInt(scn.nextLine());
        keyNumber = keyNumber - 1;
        int charCode = keyNumber % 26;

        char keyLetter = (keyNumber / 26) % 2 == 0 ? (char) ('a' + charCode)
                : Character.toUpperCase((char) ('a' + charCode));

        String key = "" + keyLetter + keyLetter;
        StringBuilder sb = new StringBuilder();

        String line = scn.nextLine();
        while (!line.equals("End")) {
            sb.append(line);
            line = scn.nextLine();
        }

        Pattern pattern = Pattern
                .compile(key + "(.*?)" + key);
        Matcher match = pattern.matcher(sb);
        while (match.find()) {
            if (match.group(1).length() > 0) {
                System.out.println(match.group(1));
            }
        }
    }
}
