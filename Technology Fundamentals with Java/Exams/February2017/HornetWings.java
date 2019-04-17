package Exams.February2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HornetWings {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        int wingFlaps = Integer.parseInt(sc.readLine());
        double distance = Long.parseLong(sc.readLine()); // distance for 1000 wings flaps
        int endurance = Integer.parseInt(sc.readLine());

        System.out.printf("%.2f m.\n",(wingFlaps / 1000.0) * distance);
        // 100 times per second
        long seconds = (wingFlaps / endurance) * 5L;
        seconds += wingFlaps / 100.0;
        System.out.printf("%d s.",seconds);
    }
}
