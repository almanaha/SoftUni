package FunctionalProgramming.Exercises;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateForName {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        int length = Integer.parseInt(sc.nextLine());
        Predicate<String> namesLength = n -> n.length() <= length;

        List<String> names = Arrays.stream(sc.nextLine().split("\\s+"))
                .filter(namesLength).collect(Collectors.toCollection(ArrayList::new));
        names.stream().filter(namesLength).forEach(System.out::println);

    }
}
