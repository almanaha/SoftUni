package Exams.March2018;

import java.io.*;
import java.util.*;

public class InternationalSoftUniada {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Map<String, Integer>> softUniada = new LinkedHashMap<>();

        String input;
        while (!"END".equals(input = sc.readLine())) {
            String[] data = input.split("->");
            String country = data[0].trim();
            String contestant = data[1].trim();
            int points = Integer.parseInt(data[2].trim());

            softUniada.putIfAbsent(country, new LinkedHashMap<>());
            // get nestedMap
            Map<String, Integer> person = softUniada.get(country);
            person.putIfAbsent(contestant, 0);
            person.put(contestant, person.get(contestant) + points);
        }

        softUniada.entrySet().stream()
                .sorted((x, y) -> {
                    int sum1 = x.getValue().values().stream().mapToInt(Integer::intValue).sum();
                    int sum2 = y.getValue().values().stream().mapToInt(Integer::intValue).sum();

                    return Integer.compare(sum2, sum1);
                })
                .forEach(e -> {
                    int sum = e.getValue().values().stream().mapToInt(Integer::intValue).sum();
                    System.out.println(e.getKey() + ": " + sum);
                    e.getValue().forEach((key, value) -> System.out.printf(" -- %s -> %d\n", key, value));
                });
    }
}