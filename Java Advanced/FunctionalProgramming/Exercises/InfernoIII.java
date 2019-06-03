package FunctionalProgramming.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.BiPredicate;

public class InfernoIII {

    private static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        numbers = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        boolean[] filtered = new boolean[numbers.length];

        String input;
        while (!"Forge".equals(input = reader.readLine())) {
            String[] tokens = input.split(";");
            String command = tokens[0];
            String direction = tokens[1];
            int sum = Integer.parseInt(tokens[2]);

            BiPredicate<Integer, Integer> isValid = getPredicate(direction, sum);
            if (isValid == null) {
                continue;
            }

            for (int i = 0; i < numbers.length; i++) {
                int currentNum = numbers[i];
                if ("Exclude".equals(command) && isValid.test(currentNum, i)) {
                    filtered[i] = true;
                } else if ("Reverse".equals(command) && isValid.test(currentNum, i)) {
                    filtered[i] = false;
                }
            }
        }

        for (int i = 0; i < numbers.length; i++) {
            if (!filtered[i]) {
                System.out.print(numbers[i] + " ");
            }
        }
    }

    private static BiPredicate<Integer, Integer> getPredicate(String direction, int sum) {
        switch (direction) {
            case "Sum Left":
                return (num, i) -> num + (i - 1 < 0 ? 0 : numbers[i - 1]) == sum;
            case "Sum Right":
                return (num, i) -> num + (i + 1 > numbers.length - 1 ? 0 : numbers[i + 1]) == sum;
            case "Sum Left Right":
                return (num, i) -> num + (i - 1 < 0 ? 0 : numbers[i - 1]) + (i + 1 > numbers.length - 1 ? 0 : numbers[i + 1]) == sum;
            default:
                return null;
        }
    }
}
