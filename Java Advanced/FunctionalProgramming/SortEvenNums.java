package FunctionalProgramming;

import java.util.*;
import java.util.stream.Collectors;

public class SortEvenNums {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        String[] matrix = sc.nextLine().split(", ");

        List<Integer> even = Arrays.stream(matrix)
                .map(Integer::parseInt)
                .filter(e -> e % 2 == 0)
                .collect(Collectors.toList());
        List<String> numbers = even.stream()
                .map(String::valueOf)
                .collect(Collectors.toList());

        System.out.println(String.join(", ", numbers));

        even.sort(Integer::compare);
        List<String> sorted = even.stream()
                .map(String::valueOf)
                .collect(Collectors.toList());

        System.out.println(String.join(", ", sorted));
    }
}
