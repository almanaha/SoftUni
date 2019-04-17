package StringProcessingAndRegex.Exercises;

import java.util.*;

public class LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] data = sc.nextLine().split("\\s+");
        double sum = 0;
        for (String s : data) {
            char first = s.charAt(0);
            char last = s.charAt(s.length() - 1);

            // start from 1(so we dont take the letter)
            // substring is exclusive(without the last symbol)
            double number = Double.parseDouble(s.substring(1, s.length() - 1));

            //If it's Uppercase you DIVIDE the number by the letter's position in the alphabet.
            if (Character.isUpperCase(first)) {
                number = number / (first - 'A' + 1);
            } else {
                //If it's lowercase you multiply the number
                number = number * (first - 'a' + 1);
            }

            // subtract or add (for last letter)
            if (Character.isUpperCase(last)) {
                number = number - (last - 'A' + 1);
            } else {
                number = number + (last - 'a' + 1); // small a (bacause of lower case
            }
            sum += number;
        }
        System.out.printf("%.2f",sum);
    }
}
