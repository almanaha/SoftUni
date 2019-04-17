package Methods;

import java.util.Scanner;

public class VowelsCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(vowelsCount(str));
    }

    public static int vowelsCount(String str) {
        int count = 0;
        String stringToLowerCase = str.toLowerCase();
        for (int i = 0; i < str.length(); i++) {
            char letter = stringToLowerCase.charAt(i);
            if (letter == 'a' || letter == 'u' ||
                    letter == 'e' || letter == 'i' || letter == 'o' || letter == 'y'){
                count++;
            }
        }
        return count;
    }
}
