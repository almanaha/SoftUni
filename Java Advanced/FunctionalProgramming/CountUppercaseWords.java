package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUppercaseWords {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        String[] text = sc.nextLine().split("\\s+");

        Predicate<String> isCapital = word -> Character.isUpperCase(word.charAt(0)) ||
                Character.isDigit(word.charAt(0));

        List<String> words = Arrays.stream(text).filter(isCapital)
                .collect(Collectors.toList());

        System.out.println(words.size());
        words.forEach(w -> System.out.println(w));
    }
}
