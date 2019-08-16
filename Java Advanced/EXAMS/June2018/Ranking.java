package EXAMS.June2018;

import java.io.*;
import java.util.*;

public class Ranking {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        Map<String, String> contests = new HashMap<>();
        Map<String, Map<String, Long>> students = new TreeMap<>();

        String input;
        while (!"end of contests".equalsIgnoreCase(input = sc.readLine())) {
            String[] data = input.split(":");
            contests.putIfAbsent(data[0], data[1]);
        }

        while (!"end of submissions".equalsIgnoreCase(input = sc.readLine())) {
            String[] data = input.split("=>");

            for (var contest : contests.entrySet()) {
                if (contest.getKey().equals(data[0]) && contest.getValue().equals(data[1])) {
                    Long points = Long.parseLong(data[3]);


                    students.putIfAbsent(data[2], new LinkedHashMap<>());
                    students.get(data[2]).putIfAbsent(data[0], points);

                    if (students.get(data[2]).get(data[0]) < points) {
                        students.get(data[2]).put(data[0], points);
                    }
                }
            }
        }

        students.entrySet().stream()
                .sorted((x, y) -> {
                    long sumX = x.getValue().values().stream().reduce((a, b) -> a += b).get();
                    long sumY = y.getValue().values().stream().reduce((a, b) -> a += b).get();
                    return Long.compare(sumY, sumX);
                })
                .limit(1)
                .forEach(e -> {
                    long total = e.getValue().values().stream().reduce((a, b) -> a += b).get();
                    System.out.printf("Best candidate is %s with total %d points.",
                            e.getKey(),
                            total)
                            .println();
                });

        System.out.println("Ranking: ");
        students.forEach((key, value) -> {

            System.out.println(key);
            value.entrySet().stream()
                    .sorted((x, y) -> Long.compare(y.getValue(), x.getValue()))
                    .forEach(s -> System.out.printf("#  %s -> %d", s.getKey(), s.getValue()).println());
        });


    }
}
