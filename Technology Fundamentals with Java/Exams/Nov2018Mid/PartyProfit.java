package Exams.Nov2018Mid;

import java.util.*;

public class PartyProfit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int companions = Integer.parseInt(sc.nextLine());
        int days = Integer.parseInt(sc.nextLine());

        int coins = 0;
        for (int i = 1; i <= days; i++) {
            if (i % 10 == 0) {
                companions -= 2;
            }
            if (i % 15 == 0) {
                companions += 5;
            }

            coins += 50;
            coins -= (companions * 2); // food


            if (i % 3 == 0) {
                coins -= (companions * 3);
            }
            if (i % 5 == 0) {
                if (i % 3 == 0) {
                    coins -= (companions * 2);
                }
                coins += (companions * 20);
            }
        }

        System.out.printf("%d companions received %d coins each.",
                companions,
                coins / companions);

    }
}

