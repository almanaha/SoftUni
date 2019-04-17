package Exams.December2018FinalExam;

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class SongEncryption {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Set<String>> bands = new HashMap<>();

        Pattern pattern = Pattern.compile("^(?<artist>[A-Z][a-z' ]+):(?<song>[A-Z ]+)$");

        String input;
        while (!"end".equals(input = sc.readLine())){
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()){
                int key = matcher.group("artist").length();
                String message = matcher.group(0);

                StringBuilder encrypted = new StringBuilder();
                for (int i = 0; i < message.length(); i++) {
                    //You should NOT ENCRYPT the following characters: ' ' and '\''
                    if (message.charAt(i) == '\'' ||
                            message.charAt(i) == ' ') {
                        encrypted.append(message.charAt(i));

                    } else if (message.charAt(i) == ':') {
                        //You also should replace ':' with the sign '@'
                        encrypted.append('@');

                    } else {
                        //Be careful if your key length is bigger than the
                        // ASCII value of a letter 'z' or 'Z'.
                        // In this case you should start from a letter 'a'.
                        int diff;
                        int current = message.charAt(i) + key;
                        if (Character.isLowerCase(message.charAt(i))) {
                            if (current > 122) {
                                //97 - 'a'
                                //122 - 'z'
                                diff = current - 122;
                                current = 96 + diff;
                                encrypted.append((char) current);
                            } else {
                                encrypted.append((char) current);
                            }
                        } else if (Character.isUpperCase(message.charAt(i))) {
                            if (current > 90) {
                                //65 - 'A'
                                //90 - 'Z'
                                diff = current - 90;
                                current = 64 + diff;
                                encrypted.append((char) current);
                            } else {
                                encrypted.append((char) current);
                            }
                        }
                    }
                }

                System.out.println("Successful encryption: " + encrypted);
            } else {
                System.out.println("Invalid input!");
            }
        }
    }
}
