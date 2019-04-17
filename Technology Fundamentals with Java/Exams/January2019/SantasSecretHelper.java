package Exams.January2019;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SantasSecretHelper {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pattern pattern = Pattern
                .compile("@(?<name>[A-Za-z]+)(?:[^@\\-:>]*)!(?<behaviour>[\\w]+)!");

        int key = Integer.parseInt(sc.nextLine());
        String cmd;
        while (!"end".equals(cmd = sc.nextLine())) {
            StringBuilder decrypted = new StringBuilder();
            for (int i = 0; i < cmd.length(); i++) {
                decrypted.append((char) (cmd.charAt(i) - key));
            }
            Matcher matcher = pattern.matcher(decrypted.toString());
            if (matcher.find()){
                if (matcher.group("behaviour").equals("G")){
                    System.out.println(matcher.group("name"));
                }
            }
        }
    }
}
