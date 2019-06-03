package FunctionalProgramming.Exercises;

import java.util.*;
import java.util.stream.Collectors;

public class CustomComparator {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));

        Comparator<Integer> comparator = ((a,b) -> {
            if (a % 2 == 0 && b % 2 != 0){
                return -1;
            }else if (a % 2 != 0 && b % 2 == 0){
                return 1;
            }
            return a.compareTo(b);
        });

        numbers.stream().sorted(comparator).forEach(e -> System.out.print(e + " "));
    }
}
