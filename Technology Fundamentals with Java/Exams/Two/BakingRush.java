package Exams.Two;

import java.util.Scanner;

public class BakingRush {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] cmd = line.split("\\|");
        int energy = 100;
        int coins = 100;

        for (String pairs : cmd) {
            String[] commands = pairs.split("-");

            switch (commands[0]) {
                case "rest":
                    int energyToGain = Integer.parseInt(commands[1]);
                    energy += energyToGain;
                    if (energy + energyToGain > 100) {
                        energy = 100;
                        System.out.printf("You gained %d energy%n",100 - energy);
                    } else {
                        energy += energyToGain;
                        System.out.printf("You gained %d energy%n",energyToGain);
                    }
                    System.out.printf("Current energy: %d%n",energy);
                    break;
                case "order":
                    if (energy - 30 < 0){
                        System.out.println("You had to rest");
                        energy += 50;
                    }else {
                        energy -= 30;
                        int coinsToAdd = Integer.parseInt(commands[1]);
                        coins += coinsToAdd;
                        System.out.printf("You earned %d coins.%n",coinsToAdd);
                    }break;
                default:
                    String ingredient = commands[0];
                    int price = Integer.parseInt(commands[1]);
                    coins -= price;
                    if (coins <= 0){
                        System.out.printf("Closed! Cannot afford %s%n", ingredient);
                        return;
                    }
                    System.out.printf("You bought %s.%n",ingredient);
                    break;
            }
        }
        System.out.println("Day completed!");
        System.out.printf("Coins: %d%n",coins);
        System.out.printf("Energy: %d%n",energy);
    }
}
