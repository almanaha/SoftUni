package Exams.July2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMon {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String text = reader.readLine();
        Pattern bojoReg = Pattern.compile("[a-zA-Z]+-[a-zA-Z]+");
        Pattern didiReg = Pattern.compile("[^a-zA-Z\\-]+");

        Matcher bojo = bojoReg.matcher(text);
        Matcher didi = didiReg.matcher(text);

        int bojoIndex = 0;
        int didiIndex = 0;
        while (true) {
            boolean dMatch = false;
            boolean bMatch = false;
            if (dMatch = didi.find(didiIndex)) {
                bojoIndex = didi.end();
                System.out.println(didi.group());
            }
            if (!dMatch) break;

            if (bMatch = bojo.find(bojoIndex)) {
                didiIndex = bojo.end();
                System.out.println(bojo.group());
            }
            if (!bMatch) break;

        }
    }
}
