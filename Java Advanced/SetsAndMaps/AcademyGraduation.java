package SetsAndMaps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class AcademyGraduation {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(sc.readLine());

        TreeMap<String, List<Double>> students = new TreeMap<>();

        while (n-- > 0) {
            String studentName = sc.readLine();
            students.putIfAbsent(studentName, new ArrayList<>());

            List<Double> score = Arrays.stream(sc.readLine().split("\\s+"))
                    .map(Double::parseDouble)
                    .collect(Collectors.toList());
            students.get(studentName).addAll(score);
        }



        students.forEach((key, value) -> {
            double sum = value.stream().reduce(Double::sum).get() / value.size();
            System.out.printf("%s is graduated with ", key);
            System.out.println(sum);
        });
    }
}