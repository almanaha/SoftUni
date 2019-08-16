package EXAMS.May2015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Olimpics {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String checker = reader.readLine();
        String[] input;

        Set<String> players;
        Map<String, Set<String>> humans = new LinkedHashMap<>();
        Map<String, Integer> wins = new LinkedHashMap<>();
        while (!checker.equals("report")) {
            input = checker.split("\\|");

            String name = input[0].trim().replaceAll("\\s{2,}", " ");
            String country = input[1].trim().replaceAll("\\s{2,}", " ");
            if (humans.containsKey(country)) {
                humans.get(country).add(name);
            } else {
                players = new HashSet<>();
                players.add(name);
                humans.put(country, players);
            }

            if (!wins.containsKey(country)) {
                wins.put(country, 1);
            } else {
                wins.put(country, wins.get(country) + 1);
            }

            checker = reader.readLine();
        }

        wins.entrySet().stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .forEach(e -> System.out.println(e.getKey() + " (" +
                        humans.get(e.getKey()).size() + " participants): "
                        + e.getValue() + " wins"));
    }
}
