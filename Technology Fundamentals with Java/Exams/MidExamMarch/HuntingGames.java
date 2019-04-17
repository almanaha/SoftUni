package Exams.MidExamMarch;

import java.util.*;

public class HuntingGames {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int days = Integer.parseInt(sc.nextLine());
        int players = Integer.parseInt(sc.nextLine());
        double energy = Double.parseDouble(sc.nextLine());
        double totalWater = Double.parseDouble(sc.nextLine()) * players * days;
        double totalFood = Double.parseDouble(sc.nextLine()) * players * days;

        for (int day = 1; day <= days; day++) {
            double work = Double.parseDouble(sc.nextLine());
            energy -= work;
            if (energy <= 0) {
                System.out.printf("You will run out of energy. You will be left with %.2f food and %.2f  water.%n", totalFood, totalWater);
                return;
            }
            if (day % 2 == 0) {
                energy *= 1.05;
                totalWater *= 0.7;
                if (day % 3 == 0) {
                    energy *= 1.1;
                    totalFood -= totalFood / players;
                }
            } else if (day % 3 == 0) {
                energy *= 1.1;
                totalFood -= totalFood / players;
            }
        }
        System.out.printf("You are ready for the quest. You will be left with - %.2f energy!%n", energy);
    }
}
