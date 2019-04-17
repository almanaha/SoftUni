package StringProcessingAndRegex.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class CaesarCipher2 {
    public static void main(String[] args) {
        Arrays.stream(
                new Scanner(System.in).nextLine().split(""))
                .forEach( c -> System.out.print((char)(c.charAt(0) + 3)));
    }
}
