package DataTypes.Exercises;

import java.util.Scanner;

public class BeerKegs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = Integer.parseInt(sc.nextLine());

        String bestKeg = "";
        double rad = 0;
        double bestVolume = 0;

        for (int i = 0; i < x; i++) {

            String kegType = sc.nextLine();
            double radius = Double.parseDouble(sc.nextLine());
            int heigth = Integer.parseInt(sc.nextLine());

            rad = Math.pow(radius,2);
            double volume = Math.PI * rad * heigth;

            if (volume > bestVolume) {
                bestVolume = volume;
                bestKeg = kegType;
            }
        }
        System.out.println(bestKeg);
    }
}
