package Exams.October2015;

import java.io.*;
import java.util.*;

public class LegendaryFarming {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));


        Map<String, Integer> materials = new TreeMap<>();
        materials.put("shards",0);
        materials.put("fragments",0);
        materials.put("motes",0);
        Map<String, Integer> junk = new TreeMap<>();

        String item = "";
        boolean toBreak = false;
        while (true) {
            if (toBreak) break;

            String[] data = sc.readLine().toLowerCase().split("\\s+");
            // i += 2  --> take pairs
            for (int i = 0; i < data.length - 1; i += 2) {
                int count = Integer.parseInt(data[i]);
                String name = data[i + 1];

                if (materials.containsKey(name)) {
                    materials.put(name, materials.get(name) + count);
                    if (materials.get(name) >= 250) {
                        materials.put(name, materials.get(name) - 250);
                        if (name.equals("shards")) {
                            item = "Shadowmourne";
                        } else if (name.equals("motes")) {
                            item = "Dragonwrath";
                        } else {
                            item = "Valanyr";
                        }
                        toBreak = true;
                        break;
                    }
                } else {
                    junk.putIfAbsent(name, 0);
                    junk.put(name, junk.get(name) + count);
                }
            }
        }

        System.out.println(item + " obtained!");
        materials.entrySet().stream()
                .sorted((x,y) -> Integer.compare(y.getValue(),x.getValue()))
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
        junk.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}
