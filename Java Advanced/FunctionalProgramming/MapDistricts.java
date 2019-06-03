package FunctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class MapDistricts {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        Map<String, List<Integer>> cities = new LinkedHashMap<>();

        String[] data = sc.readLine().split("\\s+");
        int minPopulation = Integer.parseInt(sc.readLine());

        for (int i = 0; i < data.length; i++) {
            String[] info = data[i].split(":");
            String town = info[0];
            int population = Integer.parseInt(info[1]);

            cities.putIfAbsent(town, new LinkedList<>());
            cities.get(town).add(population);
        }

        cities.entrySet().stream()
                .filter(e ->
                        e.getValue().stream()
                                .reduce(Integer::sum).get() >= minPopulation)
                .sorted((x, y) ->
                        Integer.compare(
                                y.getValue().stream().mapToInt(Integer::valueOf).sum(),
                                x.getValue().stream().mapToInt(Integer::valueOf).sum()
                        ))
                .forEach(town ->
                        System.out.printf("%s: %s",
                                town.getKey(),
                                town.getValue().stream()
                                        .sorted(Comparator.reverseOrder())
                                        .limit(5)
                                        .map(String::valueOf)
                                        .collect(Collectors.joining(" ")))
                                .println());
    }
}
