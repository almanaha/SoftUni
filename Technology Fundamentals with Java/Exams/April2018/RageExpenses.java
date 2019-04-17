package Exams.April2018;

import java.util.*;

public class RageExpenses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int lostGames = Integer.parseInt(sc.nextLine());
        double headsetPrice = Double.parseDouble(sc.nextLine());
        double mousePrice = Double.parseDouble(sc.nextLine());
        double keyboardPrice = Double.parseDouble(sc.nextLine());
        double displayPrice = Double.parseDouble(sc.nextLine());

        double total = 0;
        int count = 0;
        for (int i = 1; i <= lostGames; i++) {
            if (i % 2 == 0){
                total += headsetPrice;
            }
            if (i % 3 == 0){
                total += mousePrice;
            }
            if (i % 2 == 0 && i % 3 == 0){
                total += keyboardPrice;
                count++;
                if (count % 2 == 0){
                    total += displayPrice;
                }
            }
        }
        System.out.printf("Rage expenses: %.2f lv.",total);

    }
}
