package Exams.October2015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TinySporebat {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        Pattern pattern = Pattern.compile("^([\\w\\W]+)(\\d)$");
        int health = 5800;
        int glowcaps = 0;
        String input;
        while (!"Sporeggar".equals(input = sc.readLine())) {
            Matcher m = pattern.matcher(input);
            if (m.find()) {
                String enemies = m.group(1);
                for (int i = 0; i < enemies.length(); i++) {
                    if (enemies.charAt(i) == 'L') {
                        health += 200;
                    } else {
                        health -= enemies.charAt(i);
                    }
                    if (health <= 0) {
                        System.out.println("Died. Glowcaps: " + glowcaps);
                        return;
                    }
                }
                glowcaps += Integer.parseInt(m.group(2));
            }
        }
        //check if you can buy the sporebat. Its cost is 30 glowcaps
        System.out.println("Health left: " + health);
        if (glowcaps < 30) {
            System.out.printf("Safe in Sporeggar, but another %d Glowcaps needed.", 30 - glowcaps);
        } else {
            System.out.println("Bought the sporebat. Glowcaps left: " + (glowcaps - 30));
        }
    }
}
