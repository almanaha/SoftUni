package DataTypes;

import java.util.Scanner;

public class PtoDollars {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double pounds = Double.parseDouble(sc.nextLine());
        System.out.printf("%.3f",pounds*1.31);
    }
}
