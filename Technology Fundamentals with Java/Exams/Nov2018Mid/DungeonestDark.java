package Exams.Nov2018Mid;

import java.util.*;

public class DungeonestDark {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int health = 100;
        int coins = 0;

        String[] data = sc.nextLine().split("\\|");
        for (int i = 0; i < data.length; i++) {
            String[] room = data[i].split("\\s+");
            int number = Integer.parseInt(room[1]);
            if (room[0].equals("potion")) {
                if (health + number >= 100){
                    System.out.printf("You healed for %d hp.%n", 100 - health);
                    health = 100;
                }else{
                    health += number;
                    System.out.printf("You healed for %d hp.%n",number);
                }
                System.out.printf("Current health: %d hp.%n", health);
            } else if (room[0].equals("chest")) {
                coins += number;
                System.out.printf("You found %d coins.%n", number);
            } else {
                String monster = room[0];
                if (health - number > 0) {
                    health -= number;
                    System.out.printf("You slayed %s.%n", monster);
                    continue;
                }
                System.out.printf("You died! Killed by %s.%n", monster);
                System.out.println("Best room: " + (i + 1));
                return;
            }
        }
        System.out.println("You've made it!");
        System.out.println("Coins: " + coins);
        System.out.println("Health: " + health);

    }
}
