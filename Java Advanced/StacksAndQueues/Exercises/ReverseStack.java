package StacksAndQueues.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class ReverseStack {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Integer> numbers = new ArrayDeque<>();
        Arrays.stream(sc.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(numbers::push);

        numbers.forEach(e -> System.out.print(e + " "));

    }
}