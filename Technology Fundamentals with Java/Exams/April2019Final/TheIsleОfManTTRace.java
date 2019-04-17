package Exams.April2019Final;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TheIsleОfManTTRace {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        String input;
        while (!"".equals(input = sc.readLine())) {
            Pattern p = Pattern.compile("^([#*&$%])(?<name>[A-Za-z]+)\\1=(?<num>\\d+)!!(?<cord>.*)$");
            Matcher m = p.matcher(input);
            if (m.find()) {
                int n = Integer.parseInt(m.group("num"));
                p = Pattern.compile("^([#*&$%])(?<name>[A-Za-z]+)\\1=(\\d+)!!(?<cord>.{" + n + "})$");
                m = p.matcher(input);
                if (m.find()) {
                    StringBuilder cord = new StringBuilder();
                    String cordinates = m.group("cord");
                    for (int i = 0; i < cordinates.length(); i++) {
                        cord.append((char) (cordinates.charAt(i) + n));
                    }
                    System.out.println("Coordinates found! " + m.group("name") + " -> " + cord);
                } else {
                    System.out.println("Nothing found!");
                }
            } else {
                System.out.println("Nothing found!");
            }
        }
    }
}
