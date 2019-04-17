package MapsLambdaStreamAPI.MoreExercises;

import java.util.*;

public class Judge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LinkedHashMap<String, TreeMap<String, Integer>> judgeStatistic = new LinkedHashMap<>();

        String input;
        while (!"no more time".equalsIgnoreCase(input = sc.nextLine())) {
            String[] tokens = input.split("\\s+->\\s+");

            String user = tokens[0];
            String contest = tokens[1];
            int points = Integer.parseInt(tokens[2]);

            judgeStatistic.putIfAbsent(contest, new TreeMap<>());
            if (judgeStatistic.get(contest).containsKey(user)) {
                if (judgeStatistic.get(contest).get(user) < points) {
                    judgeStatistic.get(contest).put(user, points);
                }
            } else {
                judgeStatistic.get(contest).put(user, points);
            }

        }

        for (Map.Entry<String, TreeMap<String, Integer>> key : judgeStatistic
                .entrySet()) {
            System.out.println(String.format("%s: %d participants",
                    key.getKey(),
                    key.getValue().size()));

            int[] i = {0};
            key.getValue().entrySet().stream()
                    .sorted((f, t) -> {
                        int sort = Integer.compare(t.getValue(), f.getValue());

                        if (sort == 0) {
                            sort = f.getKey().compareTo(t.getKey());
                        }
                        return sort;
                    })
                    .forEach((e) -> {
                        System.out.println(String.format("%d. %s <::> %d",
                                i[0] + 1,
                                e.getKey(),
                                e.getValue()));
                        i[0]++;
                    });
        }

        System.out.println("Individual standings:");

        TreeMap<String, Integer> userPoints = new TreeMap<>();
        for (Map.Entry<String, TreeMap<String, Integer>> kvp : judgeStatistic.entrySet()) {

            for (Map.Entry<String, Integer> sth : kvp.getValue().entrySet()) {
                userPoints.putIfAbsent(sth.getKey(), 0);
                userPoints.put(sth.getKey(), userPoints.get(sth.getKey()) + sth.getValue());
            }
        }

        int[] i = {0};
        userPoints.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(e -> {
                            System.out.println(String.format("%d. %s -> %d",
                                    i[0] + 1,
                                    e.getKey(),
                                    e.getValue()
                            ));
                            i[0]++;
                        }
                );
    }
}
