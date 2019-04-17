package Exams.August2018;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PostOffice2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] parts = scan.nextLine().split("\\|");

        //FIRST PART --> find 1 or more capital letters from A to Z.
        Pattern capitalLetters = Pattern.compile("(?<=([#$%*&]))[A-Z]+(?=\\1)");
        Matcher matcher = capitalLetters.matcher(parts[0]);

        String startingLetters = "";
        if (matcher.find()){
            startingLetters = matcher.group();
        }
        for (int i = 0; i < startingLetters.length(); i++) {
            int symbolAscii = startingLetters.charAt(i);

            //SECOND PART --> "{asciiCode of the capital letter}:{length of the word}
            Pattern wordLength = Pattern.compile("(" + symbolAscii + "):(\\d{2})");
            matcher = wordLength.matcher(parts[1]);
            String wordRegex = "(?<=^|\\s)" + startingLetters.charAt(i);

            if (matcher.find()){
                String subLength = matcher.group(2).charAt(0) == '0' ?
                        matcher.group(2).charAt(1) + "" :
                        matcher.group(2);
                wordRegex += "[A-z]{" + subLength + "}(?=$|\\s)";
            }

            //LAST PART --> words have to start with Capital letter [A…Z]
            // equal to the ascii code and have exactly the length
            // for each capital letter you have found in the second part

            Pattern word = Pattern.compile(wordRegex);
            matcher = word.matcher(parts[2]);

            if (matcher.find()) {
                System.out.println(matcher.group());
            }
        }

    }
}