package List.MoreExercises;

import java.util.*;

public class Messaging {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        String[] numbers = sc.nextLine().split("\\s+");
        String[] words = sc.nextLine().split("\\s+");
        StringBuilder text = new StringBuilder();
        for (String word : words) {
            text.append(word);
        }

        for (int i = 0; i < numbers.length; i++) {
            int index = 0;
            for (int j = 0; j < numbers[i].length(); j++) {
                index += (int) (numbers[i].charAt(j) - '0');
            }

            if (index > text.length()) {
                index %= text.length();
            }



        }
    }
}
