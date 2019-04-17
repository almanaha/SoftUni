package StringProcessingAndRegex.Exercises;

import java.util.*;

public class StringExplosion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StringBuilder data = new StringBuilder();
        String field = sc.nextLine();
        for (int i = 0; i < field.length(); i++) {
            char symbol = field.charAt(i);
            if (symbol == '>') {
                data.append(symbol);
                i++; // take strength of explosion
                int explosion = field.charAt(i) - '0';
                explosion--; // remove the place of explosion

                while (explosion > 0 && i < field.length() - 1) {
                    i++; // move to next position for explosion
                    symbol = field.charAt(i);
                    if (symbol == '>') {
                        data.append(symbol);
                        i++;
                        explosion += field.charAt(i) - '0';
                    }
                    explosion--; // explode

                }
            } else {
                data.append(symbol);
            }
        }
        System.out.println(data);
    }
}
