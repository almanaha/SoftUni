package Exams.December2018FinalExam;

import java.util.*;

public class VaporWinterSale2 {
    static class Game {
        Double price;
        String DLC;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Game> games = new LinkedHashMap<>();
        Map<String, Game> gamesDLC = new LinkedHashMap<>();

        String[] pairs = sc.nextLine().split(", ");
        for (String pair : pairs) {
            if (pair.contains(":")) {
                String[] gameAndDLC = pair.split(":");
                String name = gameAndDLC[0];
                String DLC = gameAndDLC[1];
                if (games.containsKey(name)) {
                    Game game = games.get(name);
                    game.DLC = DLC;
                    game.price *= 1.2;
                    gamesDLC.put(name, game);
                    games.remove(name);
                }
            } else {
                String[] gameAndPrice = pair.split("-");
                String name = gameAndPrice[0];
                double price = Double.parseDouble(gameAndPrice[1]);
                Game game = new Game();
                game.price = price;
                games.put(name, game);
            }
        }

        gamesDLC.entrySet().stream()
                .sorted(Comparator.comparing(g -> g.getValue().price))
                .forEach(kvp -> System.out.printf("%s - %s - %.2f%n",
                        kvp.getKey(),
                        kvp.getValue().DLC,
                        kvp.getValue().price / 2));

        games.entrySet().stream()
                .sorted((g1, g2) -> g2.getValue().price.compareTo(g1.getValue().price))
                .forEach(kvp -> System.out.printf("%s - %.2f%n",
                        kvp.getKey(),
                        kvp.getValue().price * 0.8));
    }
}
