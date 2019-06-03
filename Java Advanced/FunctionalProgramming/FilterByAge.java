package FunctionalProgramming;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FilterByAge {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        BiPredicate<Map.Entry<String, Integer>, Integer> younger =
                (person, age) -> person.getValue() < age;

        BiPredicate<Map.Entry<String, Integer>, Integer> older =
                (person, age) -> person.getValue() >= age;

        Map<String, Integer> people = new LinkedHashMap<>();

        int n = Integer.parseInt(sc.nextLine());
        while (n-- > 0) {
            String[] data = sc.nextLine().split(", ");
            people.put(data[0], Integer.parseInt(data[1]));
        }

        String compare = sc.nextLine();
        int age = Integer.parseInt(sc.nextLine());
        String type = sc.nextLine();

        Consumer<Map.Entry<String, Integer>> printByCondition =
                person -> System.out.printf("%s - %d%n", person.getKey(), person.getValue());

        if (type.equals("age"))
            printByCondition = person -> System.out.println(person.getValue());
        else if (type.equals("name"))
            printByCondition = person -> System.out.println(person.getKey());

        people.entrySet().stream().filter(person ->
                compare.equals("younger")
                        ? younger.test(person, age)
                        : older.test(person, age))
                .forEach(printByCondition);
    }
}
