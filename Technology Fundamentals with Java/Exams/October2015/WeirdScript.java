package Exams.October2015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WeirdScript {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        // 26 -> a-z && 26 -> A-Z ---> 52 total
        int keyNum = Integer.parseInt(sc.readLine()) % 52;

        // last letter
        if (keyNum == 0) keyNum = 52;
        if (keyNum < 27) keyNum += 'a' - 1;
        else keyNum += 'A' - 26 - 1;

        //construct the key – it is done by joining two letters together
        String key = (char) keyNum + "" + (char) keyNum;
        //join letters in regex -> key + "(.*?)" + key
        Pattern pattern = Pattern.compile(key + "(.*?)" + key);

        StringBuilder sb = new StringBuilder();
        String input;
        while (!"End".equals(input = sc.readLine())) {
            sb.append(input);
        }
        Matcher matcher = pattern.matcher(sb);
        while (matcher.find()){
            System.out.println(matcher.group(1));
        }
    }
}
