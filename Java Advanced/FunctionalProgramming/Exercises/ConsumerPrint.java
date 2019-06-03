package FunctionalProgramming.Exercises;
import java.util.*;
import java.util.function.Consumer;

public class ConsumerPrint {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Consumer<String> print = System.out::println;
        Arrays.stream(sc.nextLine().split("\\s+")).forEach(print);
    }
}
