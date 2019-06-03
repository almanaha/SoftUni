package FunctionalProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class CountUpper2 {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        String[] text = sc.nextLine().split("\\s+");
        Predicate<String> checker =
                s -> s.charAt(0) == s.toUpperCase().charAt(0);

        List<String> data = new ArrayList<>();

        for (int i = 0; i < text.length; i++) {
            if (checker.test(text[i])){
                data.add(text[i]);
            }
        }
        System.out.println(data.size());
        data.forEach(System.out::println);
    }
}
