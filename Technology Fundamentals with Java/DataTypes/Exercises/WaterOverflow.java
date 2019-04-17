package DataTypes.Exercises;

import java.util.Scanner;

public class WaterOverflow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = Integer.parseInt(sc.nextLine());
        int totalLiters = 0;

        for (int i = 0; i < x; i++) {
            int liters = Integer.parseInt(sc.nextLine());

            if (totalLiters + liters > 255){
                System.out.println("Insufficient capacity!");
                continue;
            }
            totalLiters += liters;
        }
        System.out.println(totalLiters);
    }
}
