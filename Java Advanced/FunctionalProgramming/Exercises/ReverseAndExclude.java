package FunctionalProgramming.Exercises;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).boxed()
                .collect(Collectors.toCollection(ArrayList::new));
        int n = Integer.parseInt(sc.nextLine());

        BiFunction<List<Integer>, Integer, List<Integer>> reversed = ((arr, num) -> {

            Collections.reverse(arr);
            return arr.stream().filter(e -> e % num != 0)
                    .collect(Collectors.toCollection(ArrayList::new));
        });

        Consumer<List<Integer>> printer = e -> e.forEach(num -> System.out.print(num + " "));
        printer.accept(reversed.apply(numbers, n));
    }
}
