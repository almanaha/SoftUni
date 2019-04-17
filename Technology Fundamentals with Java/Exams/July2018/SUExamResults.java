package Exams.July2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class SUExamResults {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> students = new HashMap<>();
        Map<String, Integer> languages = new HashMap<>();

        String input;
        while (!"exam finished".equals(input = sc.readLine())) {
            String[] data = input.split("-");

            String name = data[0];

            if (data.length == 3) {
                String language = data[1];
                int points = Integer.parseInt(data[2]);

                if (students.containsKey(name)) {
                    if (students.get(name) < points) {
                        students.put(name, points);
                    }
                }else{
                    students.put(name, points);
                }
                languages.putIfAbsent(language, 0);
                languages.put(language, languages.get(language) + 1);

            } else {
                students.remove(name);
            }
        }

        System.out.println("Results:");
        students.entrySet().stream()
                .sorted((x,y) -> x.getValue() == y.getValue() ?
                        x.getKey().compareTo(y.getKey()) :
                        Integer.compare(y.getValue(),x.getValue()))
                .forEach(e -> System.out.println(e.getKey() + " | " + e.getValue()));

        System.out.println("Submissions:");
        languages.entrySet().stream()
                .sorted((x,y) -> x.getValue() == y.getValue() ?
                        x.getKey().compareTo(y.getKey()) :
                        Integer.compare(y.getValue(),x.getValue()))
                .forEach(e -> System.out.println(e.getKey() + " - " + e.getValue()));
    }
}
