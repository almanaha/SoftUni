package EXAMS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class FootballStats {
    private static Map<String, List<String>> team = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        String input;
        while (!"Season End".equalsIgnoreCase(input = sc.readLine())){
            String[] data = input.split("\\s+");
            String team1 = data[0];
            String team2 = data[2];

            team.putIfAbsent(team1, new LinkedList<>());
            team.putIfAbsent(team2, new LinkedList<>());

            int[] goals = Arrays.stream(data[4].split(":"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            if (goals[0] > goals[1]){
                results(team1,team2,goals[0],goals[1]);
            }else {
                results(team2,team1,goals[1],goals[0]);
            }
        }

        String[] winners = sc.readLine().split(", ");

        for (String winner : winners) {
            team.get(winner).stream()
                    .sorted(Comparator.comparing(x -> x.split(" -> ")[0]))
                    .forEach(team -> System.out.println(winner + " - " + team));
        }

    }

    private static void results(String winner, String loooser, int home, int opponent) {
        String win = "" + loooser + " -> " + home + ":" + opponent;
        String los = "" + winner + " -> " + opponent + ":" + home;
        team.get(winner).add(win);
        team.get(loooser).add(los);
    }

}
