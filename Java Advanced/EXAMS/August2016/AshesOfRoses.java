package EXAMS.August2016;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AshesOfRoses {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Map<String, Long>> ashes = new TreeMap<>();

        Pattern pattern = Pattern.compile("^Grow\\s<(?<name>[A-Z][a-z]+)>\\s<(?<color>[A-Za-z0-9]+)>\\s(?<roses>[0-9]+)$");

        String input;
        while (!"Icarus, Ignite!".equals(input = sc.readLine())){
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()){
                String dragon = matcher.group("name");
                String color = matcher.group("color");
                int roses = Integer.parseInt(matcher.group("roses"));

                ashes.putIfAbsent(dragon, new TreeMap<>());
                ashes.get(dragon).putIfAbsent(color, 0L);
                ashes.get(dragon).put(color, ashes.get(dragon).get(color) + roses);
            }
        }

        ashes.entrySet().stream()
                .sorted((x,y) -> {
                    long first = x.getValue().values().stream().reduce((a,b) -> a += b).get();
                    long second = y.getValue().values().stream().reduce((a,b) -> a += b).get();
                    return Long.compare(second,first);
                })
                .forEach(e -> {
                    System.out.println(e.getKey());
                    e.getValue().entrySet().stream()
                            .sorted(Comparator.comparingLong(Map.Entry::getValue))
                            .forEach(rose -> System.out.printf("*--%s | %d",rose.getKey(),rose.getValue()).println());
                });
    }
}
