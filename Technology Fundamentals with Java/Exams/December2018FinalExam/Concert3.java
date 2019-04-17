package Exams.December2018FinalExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Concert3 {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Set<String>> bands = new HashMap<>();
        Map<String, Integer> timePlayed = new HashMap<>();

        String input;
        int totalTime = 0;
        while (!"start of concert".equals(input = sc.readLine())) {
            String[] data = input.split("; ");
            String band = data[1];
            if (data[0].equals("Add")) {
                List<String> members = Arrays.stream(data[2].split(", "))
                        .collect(Collectors.toList());
                bands.putIfAbsent(band, new LinkedHashSet<>());
                bands.get(band).addAll(members);
            } else {
                int time = Integer.parseInt(data[2]);
                totalTime += time;
                timePlayed.putIfAbsent(band, 0);
                timePlayed.put(band, timePlayed.get(band) + time);
            }
        }
        String winners = sc.readLine();
        System.out.println("Total time: " + totalTime);
        timePlayed.entrySet().stream()
                .sorted((x,y) -> x.getValue() == y.getValue() ?
                        x.getKey().compareTo(y.getKey()) :
                        Integer.compare(y.getValue(),x.getValue()))
                .forEach(e -> System.out.println(e.getKey() + " -> " + e.getValue()));
        System.out.println(winners);
        bands.get(winners).forEach(x-> System.out.println("=> " + x));
    }
}
