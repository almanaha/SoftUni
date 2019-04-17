package MapsLambdaStreamAPI.Exercises;

import java.util.*;

public class Courses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, List<String>> courses = new LinkedHashMap<>();

        String input;
        while (!"end".equals(input = sc.nextLine())) {
            String[] data = input.split(" : ");
            String course = data[0];
            String student = data[1];

            courses.putIfAbsent(course, new ArrayList<>());
            courses.get(course).add(student);
        }

        courses.entrySet()
                .stream()
                .sorted((x, y) ->
                        Integer.compare(y.getValue().size(),
                                x.getValue().size()))
                .forEach(entry -> {
                    System.out.println(entry.getKey() + ": " + entry.getValue().size());
                    entry.getValue()
                            .stream()
                            .sorted(Comparator.naturalOrder())
                            .forEach(e -> System.out.println("-- " + e));
                });


    }
}
