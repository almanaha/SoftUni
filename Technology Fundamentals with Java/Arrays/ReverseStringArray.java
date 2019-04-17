package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseStringArray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] letters = Arrays.stream(sc.nextLine()
                .split(" "))
                .toArray(String[]::new);

        for (int i = 0; i < letters.length / 2; i++) {
            String index = letters[i];
            letters[i] = letters[letters.length - i - 1];
            letters[letters.length - i - 1] = index;
        }
        for (String let : letters) {
            System.out.print(let + " ");
        }
    }
}
