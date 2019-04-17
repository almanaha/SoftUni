package Arrays.MoreExercises;

import java.util.*;

public class EncryptSortAndPrintArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int linesCount = Integer.parseInt(scanner.nextLine());

        String[] names = new String[linesCount];
        int[] sumEveryName = new int[names.length];

        for (int i = 0; i < names.length; i++) {
            names[i] = scanner.nextLine();
        }

        for (int i = 0; i < names.length; i++) { //въртим елементите = на всяка дума...
            int sum = 0;
            for (int j = 0; j < names[i].length(); j++) { //въртим чаровете по всяка дума...
                char letter = names[i].charAt(j);
                int vowel = 0;
                int consonant = 0;
                if (letter == 'a' || letter == 'e'
                        || letter == 'i' || letter == 'o'
                        || letter == 'u' || letter == 'A'
                        || letter == 'E' || letter == 'I'
                        || letter == 'O' || letter == 'U') {
                    vowel = (int) letter * names[i].length();
                    // sum += vowel;
                } else {
                    consonant = (int) letter / names[i].length();
                    //  sum += consonant;
                }
                sum += vowel + consonant;
            }
            sumEveryName[i] = sum;
        }

        Arrays.sort(sumEveryName);
        for (int i = 0; i < names.length; i++) {
            System.out.println(sumEveryName[i]);
        }
    }
}
