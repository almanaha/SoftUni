package FunctionalProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindEvenOrOdds {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        Predicate<Integer> byType = number -> number % 2 == 0;

        int[] data = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        String type = sc.nextLine();
        if (type.equals("odd")){
            byType = number -> number % 2 != 0;
        }
        List<Integer> result = IntStream.rangeClosed(data[0],data[1])
                .boxed()
                .filter(byType)
                .collect(Collectors.toList());

        result.forEach(e -> System.out.print(e + " "));



    }
}
