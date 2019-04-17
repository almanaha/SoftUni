package Exams.Basics;

import java.util.*;

public class HighJump {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int bar = Integer.parseInt(sc.nextLine());
        int startBar = bar - 30;
        int bestBar = 0;
        int totalJumps = 0;
        int fail = 0;
        while (startBar <= bar) {
            int jump = Integer.parseInt(sc.nextLine());
            totalJumps++;
            if (bestBar == bar){
                break;
            }
            if (jump > startBar) {
                startBar += 5;
                bestBar = startBar;
                fail = 0;
            } else {
                fail++;
            }
            if (fail == 3) {
                System.out.printf("Tihomir failed at %dcm after %d jumps.", bestBar, totalJumps);
                return;
            }
        }
        System.out.printf("Tihomir succeeded, he jumped over %dcm after %d jumps.", bestBar, totalJumps);
    }
}
