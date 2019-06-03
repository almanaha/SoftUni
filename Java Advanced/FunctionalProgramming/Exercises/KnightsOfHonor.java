package FunctionalProgramming.Exercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class KnightsOfHonor {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Consumer<String> print = e -> System.out.printf("Sir %s%n",e);
        Arrays.stream(sc.nextLine().split("\\s+")).forEach(print);
    }
}
