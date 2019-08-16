package EXAMS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FootballStats2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String[]> mathcScores = new ArrayList<>();

        String input;
        while (!"Season End".equalsIgnoreCase(input = reader.readLine())) {
            String[] tokens = input.split("result");
            String[] teams = Arrays.stream(tokens[0].split("-"))
                    .map(String::trim)
                    .toArray(String[]::new);
            String[] score = Arrays.stream(tokens[1].split(":"))
                    .map(String::trim)
                    .toArray(String[]::new);

            String straightMatch = teams[0] + " - " + teams[1];
            String straightScore = score[0] + ":" + score[1];

            String reversedMatch = teams[1] + " - " + teams[0];
            String reversedScore = score[1] + ":" + score[0];
            mathcScores.add(new String[]{straightMatch, straightScore});
            mathcScores.add(new String[]{reversedMatch, reversedScore});
        }
        String[] query = reader.readLine().split(", ");
        for (String host : query) {
            mathcScores.stream()
                    .filter(strings -> strings[0].startsWith(host))
                    .sorted(Comparator.comparing(o -> o[0]))
                    .forEach(e -> System.out.printf("%s -> %s%n", e[0], e[1]));

        }
    }
}
