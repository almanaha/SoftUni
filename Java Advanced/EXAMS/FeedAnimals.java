package EXAMS;

import java.io.*;
import java.util.*;

public class FeedAnimals {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Map<String, Integer>> animalKingdom = new LinkedHashMap<>();

        String input;
        while (!"Last Info".equals(input = sc.readLine())) {
            String[] data = input.split(":");
            String beast = data[1];
            int foodLimit = Integer.parseInt(data[2]);
            animalKingdom.putIfAbsent(data[3], new LinkedHashMap<>());
            Map<String, Integer> animals = animalKingdom.get(data[3]);
            switch (data[0]) {
                case "Add":
                    animals.putIfAbsent(beast, 0);
                    animals.put(beast, animals.get(beast) + foodLimit);
                    break;
                case "Feed":
                    if (animals.containsKey(beast) && animals.get(beast) - foodLimit <= 0) {
                        System.out.println(beast + " was successfully fed");
                        animals.remove(beast);
                    } else if (animals.containsKey(beast)) {
                        animals.put(beast, animals.get(beast) - foodLimit);
                    }
                    break;
            }
        }

        Map<String, Integer> lasSurvivors = new HashMap<>();
        animalKingdom.forEach((k, v) -> v.forEach(lasSurvivors::put));

        System.out.println("Animals:");
        lasSurvivors.entrySet().stream()
                .sorted((x, y) -> Integer.compare(y.getValue(), x.getValue()))
                .forEach(e -> System.out.printf("%s -> %sg\n",e.getKey(),e.getValue()));

        System.out.println("Areas with hungry animals:");
        animalKingdom.entrySet().stream()
                .filter(e -> e.getValue().size() > 0)
                .sorted((x, y) -> Integer.compare(y.getValue().size(), x.getValue().size()))
                .forEach(e -> System.out.println(e.getKey() + " : " + e.getValue().size()));
    }
}
