package Exams.January2018;

import java.math.BigInteger;
import java.util.*;

public class Snowballs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BigInteger snowball = BigInteger.ZERO;
        int bestSnow = 0;
        int bestTime = 0;
        int bestQuality = 0;

        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            int snow = Integer.parseInt(sc.nextLine());
            int time = Integer.parseInt(sc.nextLine());
            int value = Integer.parseInt(sc.nextLine());

            int result = snow / time;

            BigInteger ball = BigInteger.valueOf(result);
            ball = ball.pow(value);

            if (ball.compareTo(snowball) > 0) {
                snowball = ball;
                bestSnow = snow;
                bestTime = time;
                bestQuality = value;
            }
        }
        System.out.println(String.format("%d : %d = %d (%d)", bestSnow,
                bestTime, snowball, bestQuality));
    }
}
