package EXAMS.February2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Highscore {
    private static Map<String, Long> scores = new LinkedHashMap<>();
    private static Map<String, List<String>> duels = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        String input;
        while (!"osu!".equals(input = sc.readLine())) {
            //{player1Score} {player1Name}<->{player2Name} {player2Score}”

            String[] data = input.split("<->");
            String player1 = data[0].split("\\s+")[1];
            String player2 = data[1].split("\\s+")[0];
            scores.putIfAbsent(player1, 0L);
            scores.putIfAbsent(player2, 0L);
            duels.putIfAbsent(player1, new LinkedList<>());
            duels.putIfAbsent(player2, new LinkedList<>());

            long p1Score = Long.parseLong(data[0].split("\\s+")[0]);
            long p2Score = Long.parseLong(data[1].split("\\s+")[1]);

            if (p1Score > p2Score) {
                results(player1, player2, p1Score - p2Score);
            } else {
                results(player2, player1, p2Score - p1Score);
            }
        }

        scores.entrySet().stream()
                .sorted((a,b) -> Long.compare(b.getValue(),a.getValue()))
                .forEach(player -> {
                    System.out.printf("%s - (%d)\n",player.getKey(),player.getValue());
                    System.out.println(String.join("\n",duels.get(player.getKey())));
                });

    }

    private static void results(String winner, String loser, long diff) {
        scores.put(winner, scores.get(winner) + diff);
        scores.put(loser, scores.get(loser) - diff);
        String win = String.format("*   %s <-> %d",loser,diff);
        String lose = String.format("*   %s <-> -%d",winner,diff);
        duels.get(winner).add(win);
        duels.get(loser).add(lose);
    }


}
