package Exams.April2019Final;

import java.io.*;
import java.util.*;

public class PracticeSessions {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        Map<String, List<String>> maps = new LinkedHashMap<>();

        String input;
        while (!"END".equals(input = sc.readLine())) {

            String[] data = input.split("->");
            String road = data[1];
            String racer = "";
            switch (data[0]) {
                case "Add":
                    racer = data[2];
                    maps.putIfAbsent(road, new LinkedList<>());
                    maps.get(road).add(racer);
                    break;
                case "Move":
                    racer = data[2];
                    if (maps.get(road).contains(racer)) {
                        String nextRoad = data[3];
                        maps.get(nextRoad).add(racer);
                        maps.get(road).remove(racer);
                    }
                    break;
                case "Close":
                    maps.remove(road);
                    break;
            }
        }
        System.out.println("Practice sessions:");
        maps.entrySet().stream()
                .sorted((x, y) ->
                        y.getValue().size() == x.getValue().size() ?
                                x.getKey().compareTo(y.getKey()) :
                                Integer.compare(y.getValue().size(), x.getValue().size()))
                .forEach(e -> {
                    System.out.println(e.getKey());
                    e.getValue().forEach(i -> System.out.println("++" + i));
                });
    }
}
