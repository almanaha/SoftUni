package MapsLambdaStreamAPI.Exercises;

import java.util.*;

public class SoftUniExamResults {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Integer> users = new HashMap<>();
        Map<String, Integer> submissions = new HashMap<>();

        String input;
        while (!"exam finished".equals(input = sc.nextLine())) {
            String[] data = input.split("-");

            //"{username}-{language}-{points}"
            if (data.length == 3) {
                String name = data[0];
                String language = data[1];
                Integer points = Integer.parseInt(data[2]);

                if (!users.containsKey(name)) {
                    users.put(name, points);
                } else if (users.get(name) < points) {
                    // save new best points
                    users.put(name, points);
                }

                if (!submissions.containsKey(language)) {
                    submissions.put(language, 1);
                } else {
                    submissions.put(language, submissions.get(language) + 1);
                }
            } else {
                //"{username}-banned".
                // In that case, you should remove the user from the contest,
                // but keep his submissions in the total count of submissions
                users.remove(data[0]);
            }
        }

        System.out.println("Results:");

        // Print the exam results for each participant
        // Ordered descending by max points and then by username
        users.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue()
                        .reversed()
                        .thenComparing(Map.Entry.comparingByKey()))
                .forEach(e -> System.out.printf("%s | %d%n", e.getKey(), e.getValue()));

        System.out.println("Submissions:");

        //After that we print each language along with the count of submissions
        // ordered descending by submissions count, and then by language name.
        submissions.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue()
                        .reversed()
                        .thenComparing(Map.Entry.comparingByKey()))
                .forEach(e -> System.out.printf("%s - %d%n", e.getKey(), e.getValue()));

    }
}
