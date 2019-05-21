package SetsAndMaps.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class MinersTask {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> bag = new HashMap<>();

        String input;
        while (!"stop".equals(input = sc.readLine())) {
            int gold = Integer.parseInt(sc.readLine());
            bag.putIfAbsent(input, 0);
            bag.put(input, bag.get(input) + gold);
        }

        bag.forEach((key1, value) -> System.out.println(key1 + " -> " + value));
    }
}
