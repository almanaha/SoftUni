package Methods;

import java.util.Scanner;

public class MathPower {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double x = Double.parseDouble(sc.nextLine());
        int y = Integer.parseInt(sc.nextLine());
        double power = PowerOfNumber(x,y);
        System.out.println(power);
    }

    public static double PowerOfNumber(double x , int y) {
        double power = 0d;
        power = Math.pow(x,y);
        return power;
    }
}
