package Exams.July2018PartOne;

import java.util.*;
import java.util.stream.Collectors;

public class SUCoursePlanning {
    public static List<String> plan;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        plan = Arrays.stream(sc.nextLine().split(", "))
                .collect(Collectors.toList());

        String input = sc.nextLine();
        while (!input.equals("course start")) {
            String[] data = input.split(":");
            String course = data[1];

            switch (data[0]) {
                case "Add":
                    if (!plan.contains(course)) {
                        plan.add(course);
                    }
                    break;
                case "Insert":
                    insert(course, Integer.parseInt(data[2]));
                    break;
                case "Remove":
                    remove(course);
                    break;
                case "Swap":
                    String course2 = data[2];
                    swap(course, course2);
                    break;
                case "Exercise":
                    addExercise(course);
                    break;
            }
            input = sc.nextLine();
        }

        for (int i = 0; i < plan.size(); i++) {
            System.out.printf("%d.%s%n", i + 1, plan.get(i));
        }
    }

    private static void addExercise(String course) {
        int index = plan.indexOf(course);
        String exercise = course + "-Exercise";
        if (plan.contains(course) && !plan.get(index).equals(exercise)) {
            plan.add(index + 1, exercise);
        } else {
            plan.add(course);
            plan.add(exercise);
        }
    }

    private static void swap(String course, String course2) {
        int index1 = plan.indexOf(course);
        int index2 = plan.indexOf(course2);
        String exercise1 = course + "-Exercise";
        String exercise2 = course2 + "-Exercise";


        if (index1 != -1 && index2 != -1) {
            plan.set(index1, course2);
            plan.set(index2, course);

            if (index1 + 1 < plan.size() && plan.get(index1 + 1).equals(exercise1)) {
                plan.remove(index1 + 1);
                plan.add(index2 + 1, exercise1);
            }
            if (index2 + 1 < plan.size() && plan.get(index2 + 1).equals(exercise2)) {
                plan.remove(index2 + 1);
                plan.add(index1 + 1, exercise2);
            }
        }
    }

    private static void remove(String course) {
        int index = plan.indexOf(course);
        if (index + 1 < plan.size() && plan.get(index + 1).equals(course + "-Exercise")) {
            plan.subList(index, index + 1).clear(); // index2 + 1
        } else {
            plan.remove(index);
        }
    }
    private static void insert(String course, int index) {
        if (!plan.contains(course)) {
            if (index >= 0 && index < plan.size()) {
                plan.add(index, course);
            }
        }
    }
}
