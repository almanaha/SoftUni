package SetsAndMaps;

import java.io.*;
import java.util.*;

public class AvgStudentsGrade {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        Map<String, List<Double>> students = new TreeMap<>();
        int gradesCount = Integer.parseInt(sc.readLine());

        for (int i = 0; i < gradesCount; i++) {
            String[] data = sc.readLine().split("\\s+");

            students.putIfAbsent(data[0], new ArrayList<>());
            students.get(data[0]).add(Double.parseDouble(data[1]));

        }

        for (String id : students.keySet()) {
            System.out.print(id + " -> ");
            double sum = 0;
            List<Double> studentGrade = students.get(id);

            for (Double grade : students.get(id)) {
                sum += grade;
                System.out.printf("%.2f ", grade);
            }
            double avg = sum / studentGrade.size();
            System.out.printf("(avg: %.2f)%n", avg);
        }
    }
}
