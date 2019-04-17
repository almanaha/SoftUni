package MapsLambdaStreamAPI.Exercises;

import java.util.*;

public class StudentAcademy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, ArrayList<Double>> students = new LinkedHashMap<>();

        int x = Integer.parseInt(sc.nextLine());

        while (x-- > 0) {
            String name = sc.nextLine();
            double grade = Double.parseDouble(sc.nextLine());

            if (!students.containsKey(name)) {
                students.put(name, new ArrayList<>());
                students.get(name).add(grade);
            } else {
                students.get(name).add(grade);
            }
        }
        Map<String, Double> avgGrades = new LinkedHashMap<>();

        for (String name : students.keySet()) {
            double sum = 0;
            for (int i = 0; i < students.get(name).size(); i++) {
                sum += students.get(name).get(i);
            }
            double avg = sum / students.get(name).size();

            if (avg >= 4.50) {
                avgGrades.put(name, avg);
            }
        }
        avgGrades.entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .forEach(e -> System.out.printf("%s -> %.2f%n", e.getKey(), e.getValue()));
    }
}
