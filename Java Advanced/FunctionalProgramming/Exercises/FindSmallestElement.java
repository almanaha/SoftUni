package FunctionalProgramming.Exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindSmallestElement {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));

        Function<List<Integer>,Integer> findIndex =
                e -> e.lastIndexOf(e.stream().min(Integer::compareTo).get());

        System.out.println(findIndex.apply(numbers));
    }
}
