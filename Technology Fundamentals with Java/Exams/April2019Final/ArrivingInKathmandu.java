package Exams.April2019Final;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArrivingInKathmandu {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));


        String input;
        while (!"Last note".equals(input = sc.readLine())) {
            Pattern pattern = Pattern.compile("^(?<mountain>[!@#$?A-Za-z0-9]+)=(?<num>\\d+)<<(?<cord>.*)$");
            Matcher m = pattern.matcher(input);
            if (m.find()) {
                long number = Integer.parseInt(m.group("num"));
                String newRegex = "^(?<mountain>[!@#$?A-Za-z0-9]+)=(?<num>\\d+)<<(?<cord>.{" + number + "})$";
                pattern = Pattern.compile(newRegex);
                m = pattern.matcher(input);
                if (m.find()) {
                    StringBuilder name = new StringBuilder();
                    for (int i = 0; i < m.group("mountain").length(); i++) {
                        char c = m.group("mountain").charAt(i);
                        if (Character.isLetterOrDigit(c)) {
                            name.append(c);
                        }
                    }

                    System.out.println("Coordinates found! " + name + " -> " + m.group("cord"));
                } else {
                    System.out.println("Nothing found!");
                }
            }else {
                System.out.println("Nothing found!");
            }
        }
    }
}
