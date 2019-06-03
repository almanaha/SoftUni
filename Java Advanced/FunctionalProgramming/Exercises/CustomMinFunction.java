package FunctionalProgramming.Exercises;

import java.util.*;
public class CustomMinFunction {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int[] numbers = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        System.out.println(Arrays.stream(numbers).min().getAsInt());
    }
}
