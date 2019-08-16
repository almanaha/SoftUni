package EXAMS.June2016;

import java.io.*;
import java.util.*;

public class CubicAssault {
    private static Map<String, Map<String, Long>> meteors;
    private static final int BREAK_METEOR = 1000000;
    private static final int ADD_METEOR = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        meteors = new TreeMap<>();

        String input;
        while (!"Count em all".equalsIgnoreCase(input = sc.readLine())) {
            String[] data = input.split(" -> ");
            String meteor = data[0];
            String color = data[1];

            meteors.putIfAbsent(meteor, new TreeMap<>());
            meteors.get(meteor).putIfAbsent("Red", 0L);
            meteors.get(meteor).putIfAbsent("Green", 0L);
            meteors.get(meteor).putIfAbsent("Black", 0L);

            meteors.get(meteor).put(color, meteors.get(meteor).get(color) + Integer.parseInt(data[2]));

            if (meteors.get(meteor).get(color) >= BREAK_METEOR) {
                gatherMeteors(meteor, color);
            }
        }

        meteors.entrySet().stream()
                .sorted((x, y) -> {
                    long sumX = x.getValue().entrySet().stream().filter(e -> e.getKey().equalsIgnoreCase("Black")).map(Map.Entry::getValue).reduce((a, b) -> a += b).get();
                    long sumY = y.getValue().entrySet().stream().filter(e -> e.getKey().equalsIgnoreCase("Black")).map(Map.Entry::getValue).reduce((a, b) -> a += b).get();
                    if (sumX == sumY) {
                        return Integer.compare(x.getKey().length(), y.getKey().length());
                    }
                    return Long.compare(sumY, sumX);
                })
                .forEach(e -> {
                    System.out.println(e.getKey());
                    e.getValue().entrySet().stream()
                            .sorted((a, b) -> Long.compare(b.getValue(), a.getValue()))
                            .forEach(meteor -> System.out.printf("-> %s : %d", meteor.getKey(), meteor.getValue()).println());

                });
    }

    private static void gatherMeteors(String meteor, String color) {
        long newMeteors = meteors.get(meteor).get(color) / BREAK_METEOR;
        long meteorsToRemove = newMeteors * BREAK_METEOR;
        meteors.get(meteor).putIfAbsent("Red", 0L);
        meteors.get(meteor).putIfAbsent("Black", 0L);
        switch (color) {
            case "Green":
                meteors.get(meteor).put(color, meteors.get(meteor).get(color) - meteorsToRemove);
                color = "Red";
                meteors.get(meteor).put(color, meteors.get(meteor).get(color) + newMeteors);
                if (meteors.get(meteor).get(color) >= 1000000) {
                    meteors.get(meteor).put(color, meteors.get(meteor).get(color) - BREAK_METEOR);
                    meteors.get(meteor).put("Black", meteors.get(meteor).get("Black") + ADD_METEOR);
                }
                break;
            case "Red":
                meteors.get(meteor).put(color, meteors.get(meteor).get(color) - meteorsToRemove);
                meteors.get(meteor).put("Black", meteors.get(meteor).get("Black") + newMeteors);
                break;
        }
    }
}
