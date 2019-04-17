package Exams.December2018FinalExam;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ActivationKeys {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Pattern pattern = Pattern.compile("[A-Za-z0-9]{16,25}");
        String[] data = sc.nextLine().split("&");
        for (int i = 0; i < data.length; i++) {
            StringBuilder code = new StringBuilder();
            Matcher matcher = pattern.matcher(data[i]);
            if (matcher.find()) {
                String text = matcher.group();
                if (text.length() == 16) {
                    for (int j = 0; j < text.length(); j++) {
                        char c = text.charAt(j);
                        if (Character.isLetter(c)) {
                            code.append(Character.toUpperCase(c));
                        } else {
                            int number = 9 - (c - '0');
                            code.append(number);
                        }
                    }
                    for (int j = 4; j < code.length(); j+=5) {
                        code.insert(j, "-");
                    }
                } else {
                    for (int j = 0; j < text.length(); j++) {
                        char c = text.charAt(j);
                        if (Character.isLetter(c)) {
                            code.append(Character.toUpperCase(c));
                        } else {
                            int number = 9 - (c - '0');
                            code.append(number);
                        }
                    }
                    for (int g = 5; g < code.length(); g+=5) {
                        code.insert(g, "-");
                    }
                }
                if (i == data.length - 1){
                    System.out.print(code);
                }else{
                    System.out.print(code + ",");
                }
            }
        }
    }
}
