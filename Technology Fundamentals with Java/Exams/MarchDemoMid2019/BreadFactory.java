package Exams.MarchDemoMid2019;

import java.util.*;

public class BreadFactory {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int energy = 100;
        int coins = 100;

        String[] events = sc.nextLine().split("\\|");
        for (int i = 0; i < events.length; i++) {
            String[] data = events[i].split("-");

            switch (data[0]) {
                case "rest":
                    int gains = Integer.parseInt(data[1]);
                    if (energy + gains <= 100) {
                        energy += gains;
                        System.out.println("You gained " + gains + " energy.");
                    }else {
                        gains = 100 - energy;
                        energy = 100;
                        System.out.println("You gained " + gains + " energy.");
                    }
                    System.out.println("Current energy: " + energy + ".");
                    break;
                case "order":
                    energy -= 30;
                    int foundCoins = Integer.parseInt(data[1]);
                    if (energy < 0) {
                        System.out.println("You had to rest!");
                        energy += 80;
                    } else {
                        coins += foundCoins;
                        System.out.println("You earned " + foundCoins + " coins.");
                    }
                    break;
                default:
                    int ingredient = Integer.parseInt(data[1]);
                    coins -= ingredient;
                    if (coins <= 0) {
                        System.out.println("Closed! Cannot afford " + data[0] + ".");
                        return;
                    } else {
                        System.out.println("You bought " + data[0] + ".");
                    }
                    break;
            }
        }
        if (energy > 0) {
            System.out.println("Day completed!");
            System.out.println("Coins: " + coins);
            System.out.println("Energy: " + energy);
        }

    }
}
