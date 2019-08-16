package EXAMS.February2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ascent {
    public static Map<String, String> map = new LinkedHashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        Pattern pattern = Pattern.compile("(?<f>[_,])(?<m>[a-zA-Z]+)(?<d>[0-9])");

        String input;
        while (!"Ascend".equals(input = sc.readLine())){

            //replace if its the same match
            for (Map.Entry<String, String> word : map.entrySet()) {
                input = input.replaceAll(word.getKey(), word.getValue());
            }

            Matcher matcher = pattern.matcher(input);
            while (matcher.find()){
                String firstChar = matcher.group("f");
                String message = matcher.group("m");
                int digit = Integer.parseInt(matcher.group("d"));

                StringBuilder sb = new StringBuilder();
                if (firstChar.equals("_")){
                    for (int i = 0; i < message.length(); i++) {
                        sb.append((char)(message.charAt(i) - digit));
                    }
                }else {
                    for (int i = 0; i < message.length(); i++) {
                        sb.append((char)(message.charAt(i) + digit));
                    }
                }

                map.put(matcher.group(), sb.toString());
                input = input.replace(matcher.group(), sb.toString());
            }
            System.out.println(input);
        }

    }
}
