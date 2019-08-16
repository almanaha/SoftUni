package EXAMS.June2019Sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MakeSalad {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        Deque<String> vegies = new ArrayDeque<>();
        Arrays.stream(sc.readLine().split("\\s+"))
                .forEach(vegies::offer);

        Deque<Integer> salads = new ArrayDeque<>();
        Arrays.stream(sc.readLine().split("\\s+"))
                .mapToInt(Integer::valueOf)
                .forEach(salads::push);

        Deque<Integer> readySalads = new ArrayDeque<>();

        while (!vegies.isEmpty() && !salads.isEmpty()) {
            int currentCalories = salads.peek();
            while (currentCalories > 0 && !vegies.isEmpty()) {
                switch (vegies.poll().toLowerCase()) {
                    case "tomato":
                        currentCalories -= 80;
                        break;
                    case "carrot":
                        currentCalories -= 136;
                        break;
                    case "lettuce":
                        currentCalories -= 109;
                        break;
                    case "potato":
                        currentCalories -= 215;
                        break;
                }
            }
            readySalads.offer(salads.pop());
        }

        if (!readySalads.isEmpty()) {
            readySalads.forEach(e -> System.out.print(e + " "));
            System.out.println();
        }
        if (!vegies.isEmpty()) {
            while (!vegies.isEmpty()) {
                System.out.print(vegies.pop() + " ");
            }
        } else {
            while (!salads.isEmpty()) {
                System.out.print(salads.poll() + " ");
            }
        }


    }
}
