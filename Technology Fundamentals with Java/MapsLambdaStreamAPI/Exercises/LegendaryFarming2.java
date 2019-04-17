package MapsLambdaStreamAPI.Exercises;

import java.io.*;
import java.util.*;

public class LegendaryFarming2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> items = new LinkedHashMap<>();
        items.put("fragments", 0);
        items.put("shards", 0);
        items.put("motes", 0);

        LinkedHashMap<String, Integer> junk = new LinkedHashMap<>();

        String winner = "";

        while (winner.equals("")) {
            String[] tokens = reader.readLine().split(" ");

            for (int i = 0; i < tokens.length - 1; i += 2) {
                int quantity = Integer.parseInt(tokens[i]);
                String item = tokens[i + 1].toLowerCase();

                if (items.containsKey(item) == false) {
                    if (junk.containsKey(item)) {
                        //increment the quantity if we have the item already
                        junk.put(item, junk.get(item) + quantity);
                    } else {
                        //put the junk item if absent
                        junk.put(item, quantity);
                    }
                } else {
                    //increment the quantity of the current item
                    items.put(item, items.get(item) + quantity);

                    if (items.get(item) >= 250) {
                        if (item.equals("shards")) {
                            winner = "Shadowmourne";
                        } else if (item.equals("fragments")) {
                            winner = "Valanyr";
                        } else {
                            winner = "Dragonwrath";
                        }

                        items.put(item, items.get(item) - 250);

                        break;
                    }
                }
            }
        }
        System.out.printf("%s obtained!%n", winner);

        items.entrySet().stream().sorted((i1, i2) -> {
                    //ordered by quantity in descending order, then by name in ascending order
                    int result = Integer.compare(i2.getValue(), i1.getValue());
                    if (result == 0) { result = i1.getKey().compareTo(i2.getKey()); }
                    return result;
                })
                .forEach(i -> System.out.printf("%s: %d%n", i.getKey(), i.getValue()));

        junk.entrySet().stream()
                //print the collected junk items, in alphabetical order
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .forEach(i -> System.out.printf("%s: %d%n", i.getKey(), i.getValue()));
    }
}
