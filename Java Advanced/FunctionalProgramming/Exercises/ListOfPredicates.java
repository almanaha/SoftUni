package FunctionalProgramming.Exercises;

import java.util.*;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class ListOfPredicates {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int n = Integer.parseInt(sc.nextLine());
        List<Integer> numbers = new LinkedList<>();

        Set<Integer> div = Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toSet());

        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }

        Predicate<Integer> predicate = num -> {
            for (Integer d : div) {
                if (num % d != 0) {
                    return false;
                }
            }
            return true;
        };

        numbers.stream().filter(predicate).forEach(e -> System.out.print(e + " "));
    }
}
