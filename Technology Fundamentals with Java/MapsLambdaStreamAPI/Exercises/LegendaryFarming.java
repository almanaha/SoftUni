package MapsLambdaStreamAPI.Exercises;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean isObtained = false;

        Map<String, Integer> items = new HashMap<>();
        Map<String, Integer> junks = new TreeMap<>();

        items.put("motes", 0);
        items.put("shards", 0);
        items.put("fragments", 0);

        while (!isObtained) {
            String[] materials = sc.nextLine().split("\\s+");
            for (int i = 0; i < materials.length; i += 2) {  // i += 2
                int quantity = Integer.parseInt(materials[i]);
                String key = materials[i + 1].toLowerCase();

                if (key.equals("motes") || key.equals("shards") || key.equals("fragments")) {
                    items.put(key, items.get(key) + quantity);
                    if (items.get(key) >= 250) {
                        items.put(key, items.get(key) - 250);
                        if (key.equals("motes")) {
                            System.out.println("Dragonwrath obtained!");
                        } else if (key.equals("shards")) {
                            System.out.println("Shadowmourne obtained!");
                        } else {
                            System.out.println("Valanyr obtained!");
                        }
                        isObtained = true;
                        break;
                    }
                } else {
                    if (!junks.containsKey(key)) {
                        junks.put(key, quantity);
                    } else {
                        junks.put(key, junks.get(key) + quantity);
                    }
                }
            }
        }

        items.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue()
                        .reversed()
                        .thenComparing(Map.Entry.comparingByKey()))
                .forEach(e -> System.out.printf("%s: %d%n",
                                e.getKey(),
                                e.getValue()));

        junks.forEach((k, e) -> System.out.printf("%s: %d%n", k, e));
    }
}
