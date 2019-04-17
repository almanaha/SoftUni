package Exams.December2018FinalExam;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VaporWinterSale {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Double> games = new HashMap<>();
        Map<String, Double> dlc = new HashMap<>();

        String[] data = sc.nextLine().split(", ");
        for (String g : data) {
            if (g.contains("-")) {
                String[] game = g.split("-");
                double price = Double.parseDouble(game[1]);
                games.putIfAbsent(game[0], price);

            } else if (g.contains(":")) {
                String[] gameDLC = g.split(":");
                if (games.containsKey(gameDLC[0])) {
                    dlc.putIfAbsent(
                            gameDLC[0] + " - " + gameDLC[1],
                            games.get(gameDLC[0]));

                    games.remove(gameDLC[0]);
                }
            }
        }

        dlc.entrySet()
                .stream()
                .sorted(Comparator.comparingDouble(Map.Entry::getValue))
                .forEach(e -> System.out.printf("%s - %.2f\n",
                        e.getKey(),
                        (e.getValue() * 1.2) / 2));

        games.entrySet()
                .stream()
                .sorted((x, y) -> Double.compare(y.getValue(), x.getValue()))
                .forEach(e -> System.out.printf("%s - %.2f\n",
                        e.getKey(),
                        e.getValue() * 0.8));
    }
}
