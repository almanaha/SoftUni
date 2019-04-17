package MapsLambdaStreamAPI.MoreExercises;

import java.util.*;

public class Ranking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, String> initialInfo = new LinkedHashMap<>();
        Map<String, LinkedHashMap<String, Integer>> userDependence = new TreeMap<>();
        Map<String, Integer> sumUser = new LinkedHashMap<>();

        String input;
        while (!"end of contests".equalsIgnoreCase(input = sc.nextLine())) {
            String[] tokens = input.split("\\s+:\\s+|:");
            String contest = tokens[0];
            String password = tokens[1];
            initialInfo.putIfAbsent(contest, password);
        }

        while (!"end of submissions".equalsIgnoreCase(input = sc.nextLine())) {
            String[] tokens = input.split("=>");
            String contest = tokens[0];
            String password = tokens[1];
            String user = tokens[2];
            int points = Integer.parseInt(tokens[3]);

            if (initialInfo.containsKey(contest) && initialInfo.get(contest).equals(password)) {
                int subtractPoints = 0;

                if (!userDependence.containsKey(user)) {
                    userDependence.put(user, new LinkedHashMap<>());
                    userDependence.get(user).put(contest, points);

                } else if (userDependence.containsKey(user) &&
                        userDependence.get(user).containsKey(contest) &&
                        userDependence.get(user).get(contest) <= points) {

                    subtractPoints = userDependence.get(user).get(contest);
                    userDependence.get(user).put(contest, points);

                } else if (userDependence.containsKey(user) &&
                        userDependence.get(user).containsKey(contest) &&
                        userDependence.get(user).get(contest) > points) {

                    subtractPoints = points;

                } else if (userDependence.containsKey(user) &&
                        !userDependence.get(user).containsKey(contest)) {
                    userDependence.get(user).put(contest, points);
                }

                if (!sumUser.containsKey(user)) {
                    sumUser.put(user, points);
                } else {
                    sumUser.put(user, sumUser.get(user) + points - subtractPoints);
                }
            }

        }

        sumUser.entrySet()
                .stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()))
                .limit(1)
                .forEach((key) -> System.out.printf("Best candidate is %s with total %d points.\n",
                        key.getKey(), key.getValue()));

        System.out.println("Ranking: ");
        for (Map.Entry<String, LinkedHashMap<String, Integer>> key : userDependence.entrySet()) {
            System.out.println(key.getKey());

            key.getValue().entrySet().stream()
                    .sorted((p1, p2) -> Integer.compare(p2.getValue(), p1.getValue()))
                    .forEach(e -> System.out.printf("#  %s -> %d\n", e.getKey(), e.getValue()));
        }

    }
}
