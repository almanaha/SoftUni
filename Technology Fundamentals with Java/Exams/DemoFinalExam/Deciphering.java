package Exams.DemoFinalExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Deciphering {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        Pattern pattern = Pattern.compile("^([d-\\|#]+)$");
        Matcher matcher = pattern.matcher(sc.readLine());
        String[] keys = sc.readLine().split(" ");

        if (matcher.find()) {
            StringBuilder encrypted = new StringBuilder();
            for (int i = 0; i < matcher.group(0).length(); i++) {
                encrypted.append((char) (matcher.group(0).charAt(i) - 3));
            }
            System.out.println(encrypted.toString().replaceAll(keys[0], keys[1]));
        }else{
            System.out.println("This is not the book you are looking for.");
        }
    }
}
