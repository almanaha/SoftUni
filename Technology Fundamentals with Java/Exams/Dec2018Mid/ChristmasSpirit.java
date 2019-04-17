package Exams.Dec2018Mid;

import java.util.*;

public class ChristmasSpirit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int allowedQuantity = Integer.parseInt(sc.nextLine());
        int days = Integer.parseInt(sc.nextLine());
        int christmasSpirit = 0;
        int money = 0;

        for (int day = 1; day <= days; day++) {
            if (day % 11 == 0){
                allowedQuantity += 2;
            }
            if (day % 2 == 0) {
                money += (2 * allowedQuantity); // Ornament Set
                christmasSpirit += 5;
            }
            if (day % 3 == 0) {
                money += (5 * allowedQuantity) + (3 * allowedQuantity); // Skirt & Garlands
                christmasSpirit += 13;
            }
            if (day % 5 == 0) {
                money += (15 * allowedQuantity); // Tree Light
                christmasSpirit += 17;
            }

            if (day % 5 == 0 && day % 3 == 0) {
                christmasSpirit += 30;
            }
            if (day % 10 == 0) {
                christmasSpirit -= 20;
                money += 23;
                if (day == days) {
                    christmasSpirit -= 30;
                }
            }
        }

        System.out.println("Total cost: " + money);
        System.out.println("Total spirit: " + christmasSpirit);
    }
}
