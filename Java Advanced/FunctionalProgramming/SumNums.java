package FunctionalProgramming;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SumNums {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        String[] nums = sc.nextLine().split(", ");

        Function<String,Integer> parse = Integer::parseInt;

        List<Integer> matrix = Arrays.stream(nums).map(parse)
                .collect(Collectors.toList());

        System.out.println("Count = "+ matrix.size());

        int sum = matrix.stream().reduce(0, (x,y) -> x+y);
        System.out.println("Sum = " + sum);

    }
}
