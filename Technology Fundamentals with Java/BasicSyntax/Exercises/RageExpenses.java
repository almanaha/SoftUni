package BasicSyntax.Exercises;

import java.util.Scanner;

public class RageExpenses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lostGames = Integer.parseInt(sc.nextLine());
        double headsetPrice = Double.parseDouble(sc.nextLine());
        double mousePrice = Double.parseDouble(sc.nextLine());
        double keyboardPrice = Double.parseDouble(sc.nextLine());
        double displayPrice = Double.parseDouble(sc.nextLine());

        int countHeadsets = 0;
        int countMouses = 0;
        int countKeyboard = 0;
        int countDisplays = 0;

        for (int i = 1; i <= lostGames; i++) {
            if (i % 2 == 0){
                countHeadsets++;
            }
            if (i % 3 == 0){
                countMouses++;
            }
            if (i % 2 == 0 && i % 3 == 0){
                countKeyboard++;
                if (countKeyboard % 2 == 0){
                    countDisplays++;
                }
            }
        }

        double rageExpenses = countHeadsets * headsetPrice + countMouses * mousePrice +
                countKeyboard * keyboardPrice + countDisplays * displayPrice;
        System.out.printf("Rage expenses: %.2f lv.",rageExpenses);

    }
}
