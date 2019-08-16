package EXAMS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Deadlifting {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Map<String, Long>> winners = new TreeMap<>();

        int n = Integer.parseInt(sc.readLine());
        while (n-- > 0) {
            String[] data = sc.readLine().split("\\s+");
            winners.putIfAbsent(data[0], new TreeMap<>());
            winners.get(data[0]).putIfAbsent(data[1], 0L);
            winners.get(data[0]).put(data[1], winners.get(data[0]).get(data[1]) + Integer.parseInt(data[2]));
        }
        winners.forEach((key, value) -> {
            System.out.printf("%s : ", key);
            StringBuilder sb = new StringBuilder();
            value.entrySet().stream()
                    .sorted(Comparator.comparing(Map.Entry::getKey))
                    .forEach(e -> sb.append(String.format("%s - %d kg", e.getKey(), e.getValue()))
                            .append(", "));
            sb.replace(sb.length() - 2, sb.length() - 1, "");
            System.out.print(sb);
            System.out.println();
        });
    }
}
