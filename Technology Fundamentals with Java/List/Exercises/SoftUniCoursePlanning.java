package List.Exercises;

import java.util.*;
import java.util.stream.Collectors;

public class SoftUniCoursePlanning {
    public static List<String> courses;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        courses = Arrays.stream(sc.nextLine().split(", "))
                .collect(Collectors.toList());

        String cmd = sc.nextLine();
        while (!cmd.equals("course start")) {
            String[] data = cmd.split(":");
            String command = data[0];
            String lesson = data[1];
            int index = 0;

            switch (command) {
                case "Add":
                    if (!courses.contains(lesson)) {
                        courses.add(lesson);
                    }
                    break;
                case "Insert":
                    index = Integer.parseInt(data[2]);
                    if (!courses.contains(lesson)) {
                        if (index >= 0 && index < courses.size()) {
                            courses.add(index, lesson);
                        }
                    }
                    break;
                case "Remove":
                    if (courses.contains(lesson)) {
                        index = courses.indexOf(lesson);
                        remove(index, lesson);
                    }
                    break;
                case "Swap":
                    String newLesson = data[2];
                    swap(lesson, newLesson);
                    break;
                case "Exercise":
                    index = courses.indexOf(lesson);
                    if (courses.contains(lesson) && !courses.contains(lesson + "-Exercise")) {
                        courses.add(index + 1, lesson + "-Exercise");
                    } else if (!courses.contains(lesson)) {
                        courses.add(lesson);
                        courses.add(lesson + "-Exercise");
                    }
            }
            cmd = sc.nextLine();
        }

        for (int i = 0; i < courses.size(); i++) {
            System.out.printf("%d.%s%n", i + 1, courses.get(i));
        }
    }

    private static void swap(String lesson, String newLesson) {
        int index1 = courses.indexOf(lesson);
        int index2 = courses.indexOf(newLesson);

        if (index1 != -1 && index2 != -1) {
            courses.set(index2, lesson);
            courses.set(index1, newLesson);

            if (index1 + 1 < courses.size() && courses.get(index1 + 1).contains(lesson + "-Exercise")) {

                String course = courses.get(index1 + 1);
                courses.remove(index1 + 1);
                courses.add(index2 + 1, course);
            }
            if (index2 + 1 < courses.size() && courses.get(index2 + 1).contains(newLesson + "-Exercise")) {

                String course = courses.get(index2 + 1);
                courses.remove(index2 + 1);
                courses.add(index1 + 1, course);
            }
        }
    }

    private static void remove(int index, String lesson) {
        if (index + 1 < courses.size() && courses.get(index + 1).contains(lesson +"-Exercise")) {
            courses.subList(index, index + 1).clear();
        } else {
            courses.remove(lesson);
        }
    }
}
