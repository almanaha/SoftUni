package SetsAndMaps.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FixEmails {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        Pattern pattern = Pattern.compile("([a-zA-Z]+@[a-zA-Z]+\\.[^us|uk|com]+)");
        String input;
        while (!"stop".equals(input = sc.readLine())){
            String email = sc.readLine();
            Matcher m = pattern.matcher(email);
            if (m.find()){
                System.out.printf("%s -> %s\n",input,email);
            }
        }
    }
}
