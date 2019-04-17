package Exams.January2018;

import java.util.*;
import java.util.regex.*;

public class Snowflakes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String line = "";
        //should NOT contain letters and digits.
        String surfacePattern = "^[^A-Za-z0-9]+$";

        // should ONLY contain digits and underscores (“_”).
        String mantlePattern = "^[0-9_]+$";

        //should ONLY contain letters.
        String fullPattern = "([^A-Za-z0-9]+)([0-9_]+)(?<core>[A-Za-z]+)([0-9_]+)([^A-Za-z0-9]+)$";

        // check if the line is surface,mantle or full Pattern, if its false we continue
        boolean isFound = true;
        int coreLength = -1;

        for (int index = 1; index <= 5; index++) {
            line = sc.nextLine();

            String currentPattern = "";
            if (index == 1 || index == 5){
                currentPattern = surfacePattern;
            }else if (index == 2 || index == 4){
                currentPattern = mantlePattern;
            }else{
                currentPattern = fullPattern;
            }

            Pattern p = Pattern.compile(currentPattern);
            Matcher m = p.matcher(line);

            if (m.matches() && index == 3){
                coreLength = m.group("core").length();
            }
            if (!m.matches()){
                isFound = false;
            }
        }
        if (isFound){
            System.out.println("Valid");
            System.out.println(coreLength);
        }else{
            System.out.println("Invalid");
        }

    }
}
