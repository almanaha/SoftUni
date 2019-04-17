package Exams.Basics;

import java.util.*;

public class BaseballTournaments {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int totalGames = 0;
        double loses = 0;
        double wins = 0;

        String tournament;
        while (!"End of tournaments".equals(tournament = sc.nextLine())) {
            int games = Integer.parseInt(sc.nextLine());
            totalGames += games;
            for (int i = 1; i <= games; i++) {
                int goals = Integer.parseInt(sc.nextLine());
                int fails = Integer.parseInt(sc.nextLine());

                if (goals > fails) {
                    wins++;
                    System.out.printf("Game %d of tournament %s: win with %d points.%n",i, tournament, goals - fails);
                } else {
                    loses++;
                    System.out.printf("Game %d of tournament %s: lost with %d points.%n",i, tournament, fails - goals);
                }
            }
        }
        wins = (wins / totalGames) * 100;
        loses = (loses / totalGames) * 100;
        System.out.printf("%.2f", wins);
        System.out.println("% matches win");
        System.out.printf("%.2f", loses);
        System.out.println("% matches lost");

    }
}
