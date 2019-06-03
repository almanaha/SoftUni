package FunctionalProgramming.Exercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class AppliedArithmetic {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int[] numbers = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        Function<int[],int[]> addNum = x -> Arrays.stream(x).map(e -> ++e).toArray();
        UnaryOperator<int[]> subtractNum = x -> Arrays.stream(x).map(e -> --e).toArray();
        UnaryOperator<int[]> multiplyNum = x -> Arrays.stream(x).map(e -> e *= 2).toArray();
        Consumer<int[]> printer = x -> Arrays.stream(x).forEach(e -> System.out.print(e + " "));

        String command = sc.nextLine();
        while (!command.equals("end")){
            switch (command){
                case "add": numbers = addNum.apply(numbers); break;
                case "subtract": numbers = subtractNum.apply(numbers); break;
                case "multiply": numbers = multiplyNum.apply(numbers); break;
                    default: printer.accept(numbers);
                        System.out.println();
            }
            command = sc.nextLine();
        }
    }
}
